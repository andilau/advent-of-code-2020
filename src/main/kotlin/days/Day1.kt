package days

@AdventOfCodePuzzle(
    name = "Report Repair",
    url = "https://adventofcode.com/2020/day/1",
    date = Date(day = 1, year = 2020)
)
class Day1 : Day(1) {
    override fun partOne(): Any {
        return inputList
            .map { it.toInt() }
            .findPairOfSum(2020)
            ?.let { (a, b) -> a * b }
            ?: 0
    }

    override fun partTwo(): Any {
        return inputList
            .map { it.toInt() }
            .findTripleOfSum(2020)
            ?.let { (a, b, c) -> a * b * c }
            ?: 0
    }

    private fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
        for (first in this)
            for (second in this)
                if (first + second == sum)
                    return first to second
        return null
    }

    private fun List<Int>.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? {
        forEach { first ->
            forEach { second ->
                forEach { third ->
                    if (first + second + third == sum)
                        return Triple(first, second, third)
                }
            }
        }
        return null
    }
}
