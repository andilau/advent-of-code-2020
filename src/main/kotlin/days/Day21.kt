package days

@AdventOfCodePuzzle(
    name = "Allergen Assessment",
    url = "https://adventofcode.com/2020/day/21",
    date = Date(day = 21, year = 2020)
)
class Day21(lines: List<String>) : Puzzle {
    private val food = readFood(lines)
    private val allergens = food.values.flatten().toSet()

    override fun partOne(): Int {
        val goodIngredients: Set<String> = goodIngredients()
        return food.keys
            .sumOf { ingredients -> ingredients.count { it in goodIngredients } }
    }

    override fun partTwo(): String {
        val allergenPossibleIngredients: MutableMap<String, Set<String>> = allergenPossibleIngredients()
        val allergenExactIngredient = mutableListOf<Pair<String, String>>()

        while (allergenPossibleIngredients.isNotEmpty()) {
            val (a, i) = allergenPossibleIngredients.entries.first { it.value.size == 1 }
            allergenPossibleIngredients.remove(a)
            allergenPossibleIngredients.replaceAll { _, recipe -> recipe - i }
            allergenExactIngredient.add(a to i.first())
        }
        return allergenExactIngredient.sortedBy { it.first }.joinToString(",") { it.second }
    }

    private fun allergenPossibleIngredients(): MutableMap<String, Set<String>> {
        val good: Set<String> = goodIngredients()
        return allergens.associateWith { allergen ->
            food.entries
                .filter { allergen in it.value }
                .map { it.key - good }
                .reduce { a, b -> a intersect b }
        }.toMutableMap()
    }

    private fun goodIngredients(): Set<String> {
        val allIngredients = food.keys.flatten().toSet()
        val badIngredients = allergens.associateWith { allergen ->
            food
                .filter { allergen in it.value }
                .map { it.key }
                .reduce { acc, i -> i intersect acc }
        }.values.flatten().toSet()
        return allIngredients - badIngredients
    }

    private fun readFood(lines: List<String>): Map<Set<String>, Set<String>> =
        lines.associate { line ->
            val foods = line.substringBefore(" (contains ")
                .split(" ").toSet()
            val allergens = line.substringAfter(" (contains ").substringBefore(")")
                .split(", ").toSet()
            foods to allergens
        }
}