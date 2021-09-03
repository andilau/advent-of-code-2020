package days

class Day4 : Day(4) {
    val newLine = System.lineSeparator()

    override fun partOne(): Any =
        inputString.split("$newLine$newLine")
            .map { Passport.parse(it) }
            .count(Passport::validateRequiredFields)

    override fun partTwo(): Any {
        return inputString.split("$newLine$newLine")
            .map { Passport.parse(it) }
            .filter(Passport::validateRequiredFields)
            .filter(Passport::validateFieldValues)
            .count()
    }
}

class Passport(private val map: Map<String, String>) {
    private val fields = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"/*"cid"*/)

    fun validateRequiredFields() =
        map.keys.containsAll(fields)

    fun validateFieldValues() =
        map.all { (key, value) ->
            when (key) {
                "byr" -> value.length == 4 && value.toIntOrNull() in 1920..2002
                "iyr" -> value.length == 4 && value.toIntOrNull() in 2010..2020
                "eyr" -> value.length == 4 && value.toIntOrNull() in 2020..2030
                "hgt" -> when (value.takeLast(2)) {
                        "cm" -> value.substringBefore("cm").toIntOrNull() in 150..193
                        "in" -> value.substringBefore("in").toIntOrNull() in 59..76
                        else -> false
                    }
                "hcl" -> value.matches("""#[0-9a-f]{6}""".toRegex())
                "ecl" -> value in "amb blu brn gry grn hzl oth".split(" ").toSet()
                "pid" -> value.length == 9 && value.all(Char::isDigit)
                else -> true
            }
        }

    companion object {
        fun parse(lines: String): Passport {
            val keysAndValues = lines.split(" ", System.lineSeparator())
            val map = keysAndValues.associate {
                val (key, value) = it.split(":")
                key to value
            }
            return Passport(map)
        }
    }
}