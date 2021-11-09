package days

@AdventOfCodePuzzle(
    name = "Monster Messages",
    url = "https://adventofcode.com/2020/day/19",
    date = Date(day = 19, year = 2020)
)
class Day19(lines: List<String>) : Puzzle {
    private val dictionary: MutableMap<String, List<List<String>>> = readRules(lines)
    private val messages = readMessages(lines)

    override fun partOne() = messages.count { match(it) }

    override fun partTwo(): Int {
        dictionary["8"] = "42 | 42 8".parseRuleLine()
        dictionary["11"] = "42 31 | 42 11 31".parseRuleLine()
        return partOne()
    }

    fun match(message: String, rules: List<String> = dictionary.getValue("0").first()): Boolean {
        if (message.isEmpty() && rules.isEmpty()) return true
        if (message.isEmpty() || rules.isEmpty()) return false

        val firstRule = rules.first()
        return when {
            // match found
            message[0] == firstRule[0] ->
                match(message.drop(1), rules.drop(1))
            // reference found
            dictionary.containsKey(firstRule) ->
                dictionary.getValue(firstRule)
                    .any { match(message, it + rules.drop(1)) }
            else -> false
        }
    }

    private fun readRules(input: List<String>) = input
        .takeWhile { it.isNotEmpty() }
        .associate { line ->
            line.substringBefore(": ") to line
                .substringAfter(": ")
                .parseRuleLine()
        }.toMutableMap()

    private fun String.parseRuleLine() = split(" | ")
        .map { orRule ->
            orRule
                .split(" ")
                .map { it.trim('\"') }
        }

    private fun readMessages(input: List<String>) = input.dropWhile { it.isNotBlank() }.drop(1)
}