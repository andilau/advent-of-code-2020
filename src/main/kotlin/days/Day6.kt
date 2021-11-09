package days

@AdventOfCodePuzzle(
    name = "Custom Customs",
    url = "https://adventofcode.com/2020/day/6",
    date = Date(day = 6, year = 2020)
)
class Day6(input: String) : Puzzle {
    private val newLine = System.lineSeparator()
    private val groups: List<String> = input
        .split("$newLine$newLine")

    override fun partOne(): Int {
        return groups
            .map { it.lines().joinToString("") }
            .sumOf { it.toSet().size }
    }

    override fun partTwo(): Int {
        return groups
            .map { it -> it.split(newLine).map { it.toSet() } }
            .sumOf { it.fold(it.first()) { a, b -> a.intersect(b) }.count() }
    }
}