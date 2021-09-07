package days

class Day7 : Day(7) {
    private val bagRules: Set<BagRule> = parseLines(inputList)

    private val SHINY_GOLD = "shiny gold"

    override fun partOne(): Int =
        findParents(SHINY_GOLD).size - 1

    override fun partTwo(): Int {
        return calculateBags(SHINY_GOLD) - 1
    }

    private fun findParents(bag: String): Set<String> =
        bagRules
            .filter { it.child == bag }
            .flatMap { findParents(it.parent) }.toSet() + bag

    private fun calculateBags(bag: String): Int {
        return bagRules
            .filter { it.parent == bag }
            .sumOf { it.amount * calculateBags(it.child) } + 1
    }

    data class BagRule(val parent: String, val amount: Int, val child: String)

    fun parseLines(lines: List<String>): Set<BagRule> {
        return lines.flatMap { line ->
            val parts = line.split(" ")
            val parent = parts.take(2).joinToString(" ")
            parts.drop(4).windowed(4, 4, false).map { child ->
                BagRule(
                    parent,
                    child.first().toInt(),
                    child.drop(1).take(2).joinToString(" ")
                )
            }
        }.toSet()

    }
}