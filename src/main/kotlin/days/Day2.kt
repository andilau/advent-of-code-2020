package days

@AdventOfCodePuzzle(
    name = "Password Philosophy",
    url = "https://adventofcode.com/2020/day/2",
    date = Date(day = 2, year = 2020)
)
class Day2(val input: List<String>) : Puzzle {
    override fun partOne() = input
        .map { PasswordValidation.parse(it) }
        .count { it.isValidOne() }

    override fun partTwo() = input
        .map { PasswordValidation.parse(it) }
        .count { it.isValidTwo() }

    data class PasswordValidation(val password: String, val letter: Char, val range: IntRange) {
        fun isValidOne() =
            password.count { it == letter } in range

        fun isValidTwo() =
            (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)

        companion object {
            fun parse(line: String): PasswordValidation {
                val (rule, password) = line.split(": ")
                val (range, letter) = rule.split(" ")
                val (min, max) = range.split("-")
                return PasswordValidation(password, letter.first(), min.toInt()..max.toInt())
            }
        }
    }
}