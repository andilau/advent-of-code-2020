package days

import days.Day20.Orientation.*

@AdventOfCodePuzzle(
    name = "Jurassic Jigsaw",
    url = "https://adventofcode.com/2020/day/20",
    date = Date(day = 20, year = 2020)
)
class Day20(input: String) : Puzzle {
    private val tiles: List<Tile> = readTiles(input)
    private val seaMonster: Set<Point> = getMonsterAsPoints()

    override fun partOne(): Long = tiles
        .filter { tile -> tile.sharedSideCount(tiles) == 2 }
        .take(4)
        .fold(1L) { a, t -> a * t.id }

    override fun partTwo(): Int {
        val lineOfTiles: List<Tile> = tiles.solvePuzzle()

        val width = tiles.count().sqrt()
        val image = lineOfTiles
            .windowed(width, width)
            .flatMap { it.asString(withHeader = false, trimmed = true).lines().dropLast(1) }

        val tile = Tile(0, image)
            .allVariations()
            .dropWhile { tile -> tile.countMonsters(seaMonster).isEmpty() }
            .first()

        return tile.countHashes() - tile.countMonsters(seaMonster).size
    }

    private fun List<Tile>.solvePuzzle(): List<Tile> {
        val width = this.count().sqrt()
        var recentTile = findTopLeftTile()
        var firstInRowTile = recentTile

        return (this.indices).map { x ->
            val y = x % width
            when {
                x == 0 && y == 0 ->
                    recentTile
                y == 0 -> {
                    recentTile = firstInRowTile.findTileAndOrient(BOTTOM, TOP, this)
                    firstInRowTile = recentTile
                    recentTile
                }
                else -> {
                    recentTile = recentTile.findTileAndOrient(RIGHT, LEFT, this)
                    recentTile
                }
            }
        }.toList()
    }

    private fun Tile.findTileAndOrient(
        tileOrientation: Orientation,
        otherOrientation: Orientation,
        tiles: List<Tile>
    ): Tile {
        val tileSide = sideOn(tileOrientation)
        return tiles
            .filter { it.id != id }
            .first { it.hasSide(tileSide) }
            .allVariations()
            .first { tileSide == it.sideOn(otherOrientation) }
    }

    private fun getMonsterAsPoints(): Set<Point> {
        return """  |                  # 
                    |#    ##    ##    ###
                    | #  #  #  #  #  #   """
            .trimMargin()
            .lines()
            .mapIndexed { y, row ->
                row.mapIndexedNotNull { x, c -> if (c == '#') x to y else null }
            }.flatten().toSet()
    }

    private fun Tile.countHashes(): Int = content.sumOf { line -> line.count { it == '#' } }

    private fun Tile.countMonsters(points: Set<Point>): Set<Point> {
        val seaMonsterPoints = mutableSetOf<Point>()
        val maxX = points.maxByOrNull { point -> point.first }?.first ?: 0
        val maxY = points.maxByOrNull { point -> point.second }?.second ?: 0

        (0..(content.indices.last - maxY)).forEach { y ->
            (0..(content.first().indices.last - maxX)).forEach { x ->
                val checkPoints = points
                    .map { it + Point(x, y) }
                //
                if (checkPoints.all { content[it.second][it.first] == '#' }) {
                    seaMonsterPoints.addAll(checkPoints)
                }
            }
        }
        return seaMonsterPoints
    }

    private fun Iterable<Tile>.asString(
        withHeader: Boolean = true,
        withBody: Boolean = true,
        trimmed: Boolean = false
    ) = buildString {
        if (withHeader) appendLine(this@asString.joinToString(" ") { tile -> "Tile ${tile.id}:" })
        if (withBody) {
            if (!trimmed)
                tiles.first().content.indices.forEach { row ->
                    appendLine(this@asString.joinToString(" ") { tile -> tile.content[row] })
                }
            else {
                tiles.first().inset.indices.forEach { row ->
                    appendLine(this@asString.joinToString("") { tile -> tile.inset[row] })
                }
            }
        }
    }


    private fun findTopLeftTile(): Tile {
        return tiles
            .first { tile -> tile.sharedSideCount(tiles) == 2 }
            .allVariations()
            .first {
                it.isSideShared(BOTTOM, tiles) && it.isSideShared(RIGHT, tiles)
            }
    }

    private fun readTiles(input: String): List<Tile> {
        val newLine = System.lineSeparator()
        return input
            .trim()
            .split("$newLine$newLine")
            .map { Tile.parse(it.lines()) }
    }

    data class Tile(val id: Int, val content: List<String>) {
        private val sides: List<String> = listOf(
            content.first(),
            content.map { row -> row.last() }.joinToString(""),
            content.last(),
            content.map { row -> row.first() }.joinToString(""),
        )

        private val reversedSides: List<String> = sides.map { it.reversed() }

        fun sharedSideCount(tiles: List<Tile>): Int {
            return sides.sumOf { side ->
                tiles
                    .filterNot { it.id == id }
                    .count { it.hasSide(side) }
            }
        }

        fun isSideShared(dir: Orientation, tiles: List<Tile>): Boolean =
            tiles
                .filter { it.id != id }
                .any { tile -> tile.hasSide(sideOn(dir)) || tile.hasSide(reverseSideOn(dir)) }

        fun rotate(): Tile {
            val contentRotated = content.mapIndexed { x, row ->
                row.mapIndexed { y, _ ->
                    content[y][x]
                }.reversed().joinToString("")
            }
            return copy(content = contentRotated)
        }

        fun flip(): Tile {
            val contentFlipped = content.map { it.reversed() }
            return copy(content = contentFlipped)
        }

        fun allVariations() =
            sequence {
                var tile: Tile = this@Tile
                repeat(2) {
                    repeat(times = 4) {
                        tile = tile.rotate()
                        yield(tile)
                    }
                    tile = tile.flip()
                }
            }

        val inset: List<String>
            get() {
                val insetRange = (content.indices.first + 1) until content.indices.last
                return insetRange.map { y ->
                    content[y].slice(insetRange)
                }.toList()
            }

        fun getAsString(): String = buildString {
            appendLine("Tile $id:")
            content.forEach { appendLine(it) }
        }

        fun hasSide(side: String): Boolean = side in sides || side in reversedSides

        fun sideOn(orientation: Orientation): String = sides[orientation.ordinal]

        private fun reverseSideOn(orientation: Orientation): String = reversedSides[orientation.ordinal]

        companion object {
            fun parse(lines: List<String>): Tile {
                val id = lines[0].substringAfter(" ").substringBefore(":").toInt()
                val content = lines.drop(1).takeWhile { it.isNotBlank() }
                return Tile(id, content)
            }
        }
    }

    enum class Orientation {
        TOP, RIGHT, BOTTOM, LEFT
    }

    private fun Int.sqrt(): Int =
        generateSequence(2) { i -> i + 1 }
            .takeWhile { it * it <= this }.last()
}