package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

@DisplayName("Day 18")
class Day18Test {
    val day = Day18(emptyList())

    @TestFactory
    @DisplayName("Part 1")
    fun testPartOneData() = testData
        .map { (input, expected) ->
            DynamicTest.dynamicTest("when I start with $input then I get $expected") {
                Assertions.assertEquals(expected, day.testPartOne(input))
            }
        }

    private val testData = listOf(
        "1 + 2 * 3 + 4 * 5 + 6" to 71L,
        "1 + (2 * 3) + (4 * (5 + 6))" to 51L,
        "2 * 3 + (4 * 5)" to 26L,
        "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 437L,
        "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 12240L,
        "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 13632L
    )

    @TestFactory
    @DisplayName("Part 2")
    fun testPartTwoData() = testData2
        .map { (input, expected) ->
            DynamicTest.dynamicTest("when I start with $input then I get $expected") {
                Assertions.assertEquals(expected, day.testPartTwo(input))
            }
        }

    private val testData2 = listOf(
        "1 + 2 * 3 + 4 * 5 + 6" to 231L,
        "1 + (2 * 3) + (4 * (5 + 6))" to 51L,
        "2 * 3 + (4 * 5)" to 46L,
        "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 1445L,
        "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 669060L,
        "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 23340L
    )
}