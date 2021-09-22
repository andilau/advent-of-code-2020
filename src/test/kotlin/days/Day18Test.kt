package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.*

@DisplayName("Day 18")
class Day18Test {
    private val day = Day18()

    @DisplayName("Part 1")
    @Nested
    inner class Part1 {
        @Test
        fun testPartOne() = assertThat(day.partOne(), `is`(202553439706L))

        @TestFactory
        fun testPartOneData() = testData
            .map { (input, expected) ->
                DynamicTest.dynamicTest("when I start with $input then I get $expected") {
                    Assertions.assertEquals(expected, day.testPartOne(input))
                }
            }

        val testData = listOf(
            "1 + 2 * 3 + 4 * 5 + 6" to 71L,
            "1 + (2 * 3) + (4 * (5 + 6))" to 51L,
            "2 * 3 + (4 * 5)" to 26L,
            "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 437L,
            "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 12240L,
            "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 13632L
        )
    }

    @DisplayName("Part 2")
    @Nested
    inner class Part2 {

        @Test
        fun testPartTwo() = assertThat(day.partTwo(), `is`(88534268715686L))

        @TestFactory
        fun testPartOneData() = testData2
            .map { (input, expected) ->
                DynamicTest.dynamicTest("when I start with $input then I get $expected") {
                    Assertions.assertEquals(expected, day.testPartTwo(input))
                }
            }

        var testData2 = listOf(
            "1 + 2 * 3 + 4 * 5 + 6" to 231L,
            "1 + (2 * 3) + (4 * (5 + 6))" to 51L,
            "2 * 3 + (4 * 5)" to 46L,
            "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 1445L,
            "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 669060L,
            "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 23340L
        )
    }
}