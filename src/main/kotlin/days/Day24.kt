package days

class Day24 : Day(24) {
    override fun partOne(): Int = blackTilesOnDayOne().count()

    override fun partTwo(): Int =
        generateSequence(blackTilesOnDayOne()) { flipTilesForNextDay(it) }
            .drop(100)
            .first()
            .count()

    private fun blackTilesOnDayOne(): Set<Tile> =
        inputList
            .map { line -> pathToTile(line) }
            .groupBy { it }
            .filterValues { it.count() % 2 == 1 }
            .keys

    private fun pathToTile(line: String): Tile =
        DIRECTION_PATTERN
            .findAll(line)
            .map { it.value }
            .fold(Tile.ORIGIN) { point, direction -> point.neighbourAt(direction) }

    private fun flipTilesForNextDay(blackTiles: Set<Tile>): Set<Tile> {
        val candidates = blackTiles.plus(blackTiles.flatMap { it.neighbours }.toSet())
        return candidates.filter { candidate ->
            val blackNeighbours = candidate.neighbours.count { it in blackTiles }
            val isBlack = candidate in blackTiles
            when {
                isBlack && (blackNeighbours in setOf(0, 3, 4, 5, 6)) -> false
                !isBlack && blackNeighbours == 2 -> true
                else -> isBlack
            }
        }.toSet()
    }

    data class Tile(val x: Int, val y: Int) {
        val neighbours by lazy { NEIGHBOURS.map { this + it.value }.toSet() }

        operator fun plus(other: Tile): Tile =
            Tile(x + other.x, y + other.y)

        fun neighbourAt(direction: String): Tile = this + NEIGHBOURS.getValue(direction)

        //    nw    ne
        //       \  |
        //     w ---|--- e
        //          |  \
        //          sw  se

        companion object {
            val ORIGIN = Tile(0, 0)
            val NEIGHBOURS = mapOf(
                "e" to Tile(+1, 0),
                "w" to Tile(-1, 0),
                "ne" to Tile(+0, +1),
                "nw" to Tile(-1, +1),
                "se" to Tile(+1, -1),
                "sw" to Tile(0, -1)
            )
        }
    }

    companion object {
        private val DIRECTION_PATTERN = """([ns]?[we])""".toRegex()
    }
}