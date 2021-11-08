package days

@AdventOfCodePuzzle(
    name = "Shuttle Search",
    url = "https://adventofcode.com/2020/day/13",
    date = Date(day = 13, year = 2020)
)
class Day13(val lines: List<String>) : Day() {
    private val target = lines[0].toInt()
    private val busses = lines[1]
        .split(",")
        .mapNotNull { it.toIntOrNull() }

    override fun partOne(): Int {
        return busses
            .associateWith { timeToWait(it, target) }
            .minByOrNull { it.value }
            .let { it!!.key * it.value }
    }

    private fun timeToWait(line: Int, target: Int) =
        line - (target % line)

    override fun partTwo(): Long {
        return test(lines[1])
    }

    fun test(input: String): Long {
        val busToOffset = input
            .split(",")
            .mapIndexedNotNull { i, s -> if ("x" != s) s.toLong() to i else null }
        var step = busToOffset.first().first
        var time = 0L
        busToOffset.drop(1).forEach { (bus, offset) ->
            while ((time + offset) % bus != 0L) {
                time += step
            }
            step *= bus
        }
        return time
    }
}