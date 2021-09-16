package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

class Day18Test {
    private val day = Day18()

    @Test
    fun testPartOne() = assertThat(day.partOne(), `is`(202553439706L))

    @Test
    fun testPartTwo() = assertThat(day.partTwo(), `is`(88534268715686L))
}

@RunWith(Parameterized::class)
class Day18PartOneTest(private val numbers: String, private val number: Long) {
    companion object {
        @JvmStatic
        @Parameters
        fun data() = listOf(
            arrayOf("1 + 2 * 3 + 4 * 5 + 6", 71L),
            arrayOf("1 + (2 * 3) + (4 * (5 + 6))", 51L),
            arrayOf("2 * 3 + (4 * 5)", 26L),
            arrayOf("5 + (8 * 3 + 9 + 3 * 4 * 3)", 437L),
            arrayOf("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 12240L),
            arrayOf("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 13632L)
        )
    }

    @Test
    fun testPartOne() = assertThat(Day18().testPartOne(numbers), `is`(number))
}

@RunWith(Parameterized::class)
class Day18PartTwoTest(private val numbers: String, private val number: Long) {
    companion object {
        @JvmStatic
        @Parameters
        fun data() = listOf(
            arrayOf("1 + 2 * 3 + 4 * 5 + 6", 231L),
            arrayOf("1 + (2 * 3) + (4 * (5 + 6))", 51L),
            arrayOf("2 * 3 + (4 * 5)", 46L),
            arrayOf("5 + (8 * 3 + 9 + 3 * 4 * 3)", 1445L),
            arrayOf("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 669060L),
            arrayOf("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 23340L)
        )
    }

    @Test
    fun testPartTwo() = assertThat(Day18().testPartTwo(numbers), `is`(number))
}