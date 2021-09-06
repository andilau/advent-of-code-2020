package days

/*
light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.
*/

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