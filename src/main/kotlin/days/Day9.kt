package days

class Day9 : Day(9) {
    var preambleSize: Int = 25
    val list = inputList.map { it.toLong() }

    override fun partOne(): Long {
        return list
            .windowed(preambleSize + 1, 1, false)
            .first { !it.validPreamble() }.last()
    }

    private fun List<Long>.validPreamble(): Boolean {
        val target = last()
        val members = dropLast(1).toSet()
        return members.any { target - it in members }
    }

    override fun partTwo(): Long {
        val target = partOne()

        return list.indices.mapNotNull { start ->
            list.indices.drop(start + 1).mapNotNull { end ->
                list.subList(start, end).takeIf { target == it.sum() }
            }.firstOrNull()
        }.first()
            .let { it.minOrNull()!! + it.maxOrNull()!! }
    }
}