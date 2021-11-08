package days

@AdventOfCodePuzzle(
    name = "Crab Cups",
    url = "https://adventofcode.com/2020/day/23",
    date = Date(day = 23, year = 2020)
)
class Day23(val input: String) : Day() {
    override fun partOne(): String {
        return CupGame(input)
            .playRounds(100)
            .getCupsAfter(1)
            .getCupsAsString()
    }

    override fun partTwo(): Long {
        return CupGame(input, 1_000_000)
            .playRounds(10_000_000)
            .getCupsAfter(1)
            .take(2)
            .map { it.toLong() }
            .reduce { a, b -> a * b }
    }

    fun playRoundsAndGetCups(times: Int = 100) = CupGame(input)
        .playRounds(times)
        .getCupsAfter(1)
        .getCupsAsString()

/*
input: 389125467
| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |  #cup
| 2 | 5 | 8 | 6 | 4 | 7 | 3 | 9 | 1 |  points to #cup
*/

    class CupGame(val input: String, numberOfCups: Int = input.length) {
        private val nextCupOf: IntArray = IntArray(numberOfCups + 1) { it + 1 }
        private val cups: List<Int> = input.map(Character::getNumericValue)
        private var currentCup: Int = cups.first()

        init {
            cups.zipWithNext { a, b -> nextCupOf[a] = b }
            nextCupOf[cups.last()] = cups.first()
            if (cups.size < numberOfCups) {
                // nextCupOf elements are preset in property initializer
                nextCupOf[cups.last()] = cups.size + 1
                nextCupOf[numberOfCups] = cups.first()
            }
        }

        fun playRounds(times: Int): CupGame {
            repeat(times) {
                val a = nextCupOf[currentCup]
                val b = nextCupOf[a]
                val c = nextCupOf[b]

                val destination = findDestination(currentCup, a, b, c)

                // link currentCup
                nextCupOf[currentCup] = nextCupOf[c]
                currentCup = nextCupOf[currentCup]

                // link three elements
                val save = nextCupOf[destination]
                nextCupOf[destination] = a
                nextCupOf[c] = save
            }
            return this
        }

        fun getCupsAfter(cup: Int): Sequence<Int> {
            var current = nextCupOf[cup]
            return sequence {
                while (current != cup) {
                    yield(current)
                    current = nextCupOf[current]
                }
            }
        }

        private fun findDestination(cup: Int, a: Int, b: Int, c: Int): Int {
            var position = cup - 1
            while (true) {
                if (position != a && position != b && position != c && position >= 1) break
                if (position == 0) position = nextCupOf.size - 1
                else position--
            }
            return position
        }
    }

    private fun Sequence<Int>.getCupsAsString(): String = joinToString("")
}