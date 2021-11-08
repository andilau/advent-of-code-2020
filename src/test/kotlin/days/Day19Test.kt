package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 19")
class Day19Test {
    val lines = """
        0: 4 1 5
        1: 2 3 | 3 2
        2: 4 4 | 5 5
        3: 4 5 | 5 4
        4: "a"
        5: "b"
        
        ababbb
        bababa
        abbbab
        aaabbb
        aaaabbb
        """.trimIndent().lines()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(Day19(lines).partOne()).isEqualTo(2)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(Day19(lines).partOne()).isEqualTo(2)
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
            Assertions.assertEquals(expected, Day19(lines).match(input))
        }
    }
}