package days

class Day13 : Day(13) {
    val target = inputList[0].toInt()
    val busses = inputList[1]
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
        return test(inputList[1])
    }

    fun test(input: String): Long {
        val busToOffset = input
            .split(",")
            .mapIndexedNotNull { i, s -> if (!"x".equals(s)) s.toLong() to i else null }
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
