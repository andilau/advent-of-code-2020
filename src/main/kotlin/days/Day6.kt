package days

class Day6 : Day(6) {
    private val newLine = System.lineSeparator()
    private val groups: List<String> = inputString
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