package days

class Day23 : Day(23) {
    override fun partOne(): String {
        return CupGame(inputString)
            .firstCupAfterRound(100)
            .nextCupsAsString()
    }

    override fun partTwo(): Long {
        return CupGame(inputString, 1_000_000)
            .firstCupAfterRound(10_000_000)
            .nextTwoCups()
            .map { it.value.toLong() }
            .reduce { a, b -> a * b }
    }

    class CupGame(val input: String, numberOfCups: Int = input.length) {
        private val lookup: Array<Cup> = Array(numberOfCups + 1) { Cup(it) }
        private var currentCup: Cup

        init {
            val cups: List<Cup> = input
                .map { Character.getNumericValue(it) }
                .map { lookup[it] } + (input.length + 1..numberOfCups).map { lookup[it] }
            currentCup = cups.first()
            cups.zipWithNext { a, b -> a.next = b }
            cups.last().next = cups.first()
        }

        fun firstCupAfterRound(times: Int): Cup {
            repeat(times) {
                val threeCups: List<Cup> = currentCup.nextThreeCups()
                val insertAfterCup = findDestination(currentCup, threeCups)
                moveCupsAfter(insertAfterCup, threeCups)
                currentCup = currentCup.next
            }
            return lookup[1]
        }

        private fun findDestination(cup: Cup, excludeCups: List<Cup>): Cup {
            val exclude = excludeCups.map { it.value }.toSet()

            var pos = cup.value - 1
            while (true) {
                if (pos !in exclude && pos >= 1) break
                if (pos == 0) pos = lookup.size - 1
                else pos--
            }
            return lookup[pos]
        }

        private fun moveCupsAfter(insertAfterCup: Cup, three: List<Cup>) {
            val save = insertAfterCup.next
            currentCup.next = three.last().next
            insertAfterCup.next = three.first()
            three.last().next = save
        }
    }

    data class Cup(val value: Int) {
        lateinit var next: Cup

        fun nextCupsAsString(): String = buildString {
            var current = this@Cup.next
            while (current != this@Cup) {
                append(current.value.toString())
                current = current.next
            }
        }

        fun nextThreeCups(): List<Cup> =
            listOf(this.next, this.next.next, this.next.next.next)

        fun nextTwoCups(): List<Cup> =
            listOf(this.next, this.next.next)
    }
}