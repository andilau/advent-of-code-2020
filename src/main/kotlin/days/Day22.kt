package days

class Day22 : Day(22) {
    override fun partOne(): Int {
        val deck1: Deck = readDeckOf("Player 1")
        val deck2: Deck = readDeckOf("Player 2")
        return if (deck1.play(deck2)) deck1.score else deck2.score
    }

    override fun partTwo(): Int {
        val deck1: Deck = readDeckOf("Player 1")
        val deck2: Deck = readDeckOf("Player 2")
        return if (deck1.playRecursive(deck2)) deck1.score else deck2.score
    }

    private fun Deck.playRecursive(other: Deck): Boolean {
        val seen = mutableSetOf(this to other)

        while (isNotEmpty() && other.isNotEmpty()) {
            val a = removeFirst()
            val b = other.removeFirst()

            val winner = if (a <= size && b <= other.size)
                deckFromCardTake(a).playRecursive(other.deckFromCardTake(b))
            else
                a > b

            when {
                winner -> add(a) && add(b)
                else -> other.add(b) && other.add(a)
            }

            if (!seen.add(Pair(this, other))) return true
        }
        return this.isNotEmpty()
    }

    private fun Deck.play(other: Deck): Boolean {
        while (isNotEmpty() && other.isNotEmpty()) {
            val a = removeFirst()
            val b = other.removeFirst()
            if (a > b)
                add(a) && add(b)
            else
                other.add(b) && other.add(a)
        }
        return isNotEmpty()
    }

    private fun readDeckOf(playerName: String): Deck {
        return inputList
            .asSequence()
            .dropWhile { line -> !line.startsWith(playerName) }
            .drop(1)
            .takeWhile { line -> line.isNotBlank() }
            .map { line -> line.toInt() }
            .toMutableList()
            .let { Deck(it) }
    }

    data class Deck(val deck: MutableList<Int>) : MutableList<Int> by deck {
        val score: Int
            get() = deck.foldRightIndexed(0) { index, element, acc -> acc + (size - index) * element }

        fun deckFromCardTake(count: Int) = Deck(deck.take(count).toMutableList())
    }
}
