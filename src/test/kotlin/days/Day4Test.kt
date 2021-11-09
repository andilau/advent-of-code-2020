package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day4Test {
    val input = """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:59in

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in""".trimIndent()

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day4(input).partOne()).isEqualTo(3)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day4(input).partTwo()).isEqualTo(3)
    }
}
