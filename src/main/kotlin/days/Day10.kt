package days

@AdventOfCodePuzzle(
    name = "Adapter Array",
    url = "https://adventofcode.com/2020/day/10",
    date = Date(day = 10, year = 2020)
)
class Day10 : Day(10) {
    override fun partOne(): Int {
        return inputList
            .asSequence()
            .map { it.toInt() }
            .plus(0)
            .sorted()
            .zipWithNext { a, b -> b - a }
            .groupingBy { it }
            .eachCount()
            .run { getOrDefault(1, 1) * (1 + getOrDefault(3, 1)) }
    }

    override fun partTwo(): Long {
        val input: List<Int> = inputList.map { it.toInt() }
        val adapters = input
            .plus(0)
            .plus(input.maxOrNull()!! + 3)
            .sorted()

        val combinationsByAdapter: MutableMap<Int, Long> = mutableMapOf(0 to 1L)

        for (adapter in adapters.drop(1)) {
            combinationsByAdapter[adapter] =
                combinationsByAdapter.getOrDefault(adapter - 1, 0) +
                        combinationsByAdapter.getOrDefault(adapter - 2, 0) +
                        combinationsByAdapter.getOrDefault(adapter - 3, 0)
        }
        return combinationsByAdapter.getValue(adapters.last())
    }
}