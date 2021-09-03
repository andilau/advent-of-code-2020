package days

class Day3 : Day(3) {
    override fun partOne(): Any =
        countTrees(3 to 1)

    override fun partTwo(): Any =
        listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        .map { countTrees(it).toLong() }
        .reduce { a, b -> a * b }

    fun countTrees(vector: Pair<Int, Int>): Int {
        val dx = vector.first
        val dy = vector.second
        val width = inputList[0].length
        return inputList.indices.count { y ->
            val x = dx * y / dy % width
            (y % dy == 0) && inputList[y][x] == '#'
        }
    }
}
