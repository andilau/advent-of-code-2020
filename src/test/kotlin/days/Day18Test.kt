package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day18Test {
    private val day = Day18()

    @Test
    fun testPartOne() = assertThat(day.partOne(), `is`(202553439706L))

    @Test
    fun testPartTwo() = assertThat(day.partTwo(), `is`(88534268715686L))
}

class Day18PartOneTest {
    companion object {
        @JvmStatic
        fun data() = listOf(
            Arguments.of("1 + 2 * 3 + 4 * 5 + 6", 71L),
            Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", 51L),
            Arguments.of("2 * 3 + (4 * 5)", 26L),
            Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 437L),
            Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 12240L),
            Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 13632L)
        )
    }

    @ParameterizedTest
    @MethodSource("data")
    fun testPartOne(numbers: String, number: Long) =
        assertThat(Day18().testPartOne(numbers), `is`(number))
}

class Day18PartTwoTest {
    companion object {
        @JvmStatic
        fun data(): List<Arguments> = listOf(
            Arguments.of("1 + 2 * 3 + 4 * 5 + 6", 231L),
            Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", 51L),
            Arguments.of("2 * 3 + (4 * 5)", 46L),
            Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 1445L),
            Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 669060L),
            Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 23340L)
        )
    }

    @ParameterizedTest
    @MethodSource("data")
    fun testPartTwo(numbers: String, number: Long) = assertThat(Day18().testPartTwo(numbers), `is`(number))
}