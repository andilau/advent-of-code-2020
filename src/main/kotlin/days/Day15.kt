package days

@AdventOfCodePuzzle(
    name = "Rambunctious Recitation",
    url = "https://adventofcode.com/2020/day/15",
    date = Date(day = 15, year = 2020)
)
class Day15(input: String) : Day() {
    private val numbers: List<Int> = input.split(",").map { it.toInt() }

    override fun partOne() = numbers.elementInVanEckSequenceAt(2020)

    override fun partTwo() = numbers.elementInVanEckSequenceAt(30_000_000)

    fun elementInVanEckSequenceAt(at: Int): Int =
        numbers.elementInVanEckSequenceAt(at)

    private fun List<Int>.elementInVanEckSequenceAt(at: Int): Int {
        var index = 0               // incrementing counter
        var before: Int             // value of index when element was previously encountered
        var element = 0             // current element of vanEck sequence
        val lookup = IntArray(at)   // value of index when element was previously encountered
        // lookup[0] special case for not yet encountered
        this.forEach { lookup[it] = ++index }

        while (++index < at) {
            before = lookup[element]
            lookup[element] = index
            element = if (before == 0) 0 else index - before
        }
        return element
    }
}