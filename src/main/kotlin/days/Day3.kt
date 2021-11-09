package days

@AdventOfCodePuzzle(
    name = "Toboggan Trajectory",
    url = "https://adventofcode.com/2020/day/3",
    date = Date(day = 3, year = 2020)
)
class Day3(private val trees: List<String>) : Puzzle {
    override fun partOne(): Any =
        countTrees(3 to 1)

    override fun partTwo(): Any =
        listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { countTrees(it).toLong() }
            .reduce { a, b -> a * b }

    private fun countTrees(vector: Pair<Int, Int>): Int {
        val dx = vector.first
        val dy = vector.second
        val width = trees[0].length
        return trees.indices.count { y ->
            val x = dx * y / dy % width
            (y % dy == 0) && trees[y][x] == '#'
        }
    }
}