package days

@AdventOfCodePuzzle(
    name = "Combo Breaker",
    url = "https://adventofcode.com/2020/day/25",
    date = Date(day = 25, year = 2020)
)
class Day25 : Day(25) {
    private val cardKey = inputList.first().toLong()
    private val doorKey = inputList.last().toLong()

    override fun partOne(): Long =
        cryptSequence(cardKey)
            .drop(cryptSequence().indexOf(doorKey))
            .first()

    override fun partTwo(): Long = cryptSequence(doorKey)
        .drop(cryptSequence().indexOf(cardKey))
        .first()

    private fun cryptSequence(subject: Long = 7): Sequence<Long> =
        generateSequence(1L) { (it * subject) % 20201227 }
}