package days

//typealias Point3D = Triple<Int, Int, Int>

class Day17 : Day(17) {
    override fun partOne(): Int {
        return generateSequence(
            readInput { x, y -> Point3D(x, y, 0) }) { space -> space.next() }
            .drop(6)
            .first().size
    }

    override fun partTwo(): Int {
        var hyper = readInput { x, y -> Hypercube(x, y, 0, 0) }
        repeat(6) {
            hyper = hyper.next()
        }
        return hyper.size
    }

    private fun readInput(pointFunction: (Int, Int) -> Point): Set<Point> {
        val space = mutableSetOf<Point>()
        for (y in inputList.indices) {
            for (x in inputList[y].indices) {
                if (inputList[y][x] == '#')
                    space.add(pointFunction(x, y))
            }
        }
        return space
    }

    private fun Set<Point>.next(): Set<Point> {
        val next = mutableSetOf<Point>()
        val active = this
        val all = active
            .flatMap { point -> point.neighbors() }
            .toSet()

        all.forEach { point ->
            val activeNeighbors = point.neighbors().count { neighbor -> neighbor in active }
            when {
                point in active && activeNeighbors in setOf(2, 3) -> next.add(point)
                point !in active && activeNeighbors in setOf(3) -> next.add(point)
            }
        }
        return next
    }

    interface Point {
        fun neighbors(): List<Point>
    }

    data class Point3D(val x: Int, val y: Int, val z: Int) : Point {
        override fun neighbors(): List<Point3D> =
            (x - 1..x + 1).map { x ->
                (y - 1..y + 1).map { y ->
                    (z - 1..z + 1).mapNotNull { z ->
                        Point3D(x, y, z).takeIf { it != this }
                    }
                }.flatten()
            }.flatten()
    }

    data class Hypercube(val x: Int, val y: Int, val z: Int, val h: Int) : Point {
        override fun neighbors(): List<Hypercube> =
            (x - 1..x + 1).map { x ->
                (y - 1..y + 1).map { y ->
                    (z - 1..z + 1).map { z ->
                        (h - 1..h + 1).mapNotNull { h ->
                            Hypercube(x, y, z, h).takeIf { it != this }
                        }
                    }.flatten()
                }.flatten()
            }.flatten()
    }
}