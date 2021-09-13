package days

class Day15 : Day(15) {
    private val numbers: List<Int> = inputString.split(",").map { it.toInt() }

    override fun partOne() = numbers.solveForAnswer(2020)

    override fun partTwo() = numbers.solveForAnswer(30_000_000)

    private fun List<Int>.solveForAnswer(abortAt: Int): Int {
        val indexOfNumber = this.mapIndexed { i, x -> x to i }.toMap().toMutableMap()

        var turn = this.size
        var next = 0
        while (true) {
            val last = indexOfNumber.getOrDefault(next, turn)
            indexOfNumber[next] = turn
            next = turn - last
            if (++turn == abortAt - 1) break
        }
        return next
    }

    fun solveFor2020(numbers: String): Int {
        return numbers.split(",").map { it.toInt() }.solveForAnswer(2020)
    }

    fun solveFor30000000(numbers: String): Int {
        return numbers.split(",").map { it.toInt() }.solveForAnswer(30_000_000)
    }
}