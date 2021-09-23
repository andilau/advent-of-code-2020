package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 19")
class Day19Test {
    private val day = Day19()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(2)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partOne()).isEqualTo(2)
    }

    @TestFactory
    fun testFactory() = listOf(
        "" to false,
        "ababbb" to true,
        "abbbab" to true,
        "bababa" to false,
        "aaabbb" to false,
        "aaaabbb" to false
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("""when I start with message "$input" then I get $expected""") {
            Assertions.assertEquals(expected, day.match(input))
        }
    }
}