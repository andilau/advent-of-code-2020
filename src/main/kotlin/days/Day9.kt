package days

@AdventOfCodePuzzle(
    name = "Encoding Error",
    url = "https://adventofcode.com/2020/day/9",
    date = Date(day = 9, year = 2020)
)
class Day9(val numbers: List<Long>) : Day() {
    var preambleSize: Int = 25

    override fun partOne(): Long {
        return numbers
            .windowed(preambleSize + 1, 1, false)
            .first { !it.validPreamble() }.last()
    }

    override fun partTwo(): Long {
        val target = partOne()

        return numbers.indices.mapNotNull { start ->
            numbers.indices.drop(start + 1).mapNotNull { end ->
                numbers.subList(start, end).takeIf { target == it.sum() }
            }.firstOrNull()
        }.first()
            .let { it.minOrNull()!! + it.maxOrNull()!! }
    }

    private fun List<Long>.validPreamble(): Boolean {
        val target = last()
        val members = dropLast(1).toSet()
        return members.any { target - it in members }
    }
}