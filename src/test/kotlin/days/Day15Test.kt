package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

class Day15Test {
    private val day = Day15()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(436))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(175594))
    }
}

@RunWith(Parameterized::class)
class Day15ParameterizedPartOne(private val numbers: String, private val number: Int) {
    private val day = Day15()

    companion object {
        @JvmStatic
        @Parameters
        fun data() = listOf(
            arrayOf("0,3,6", 436),
            arrayOf("1,3,2", 1),
            arrayOf("2,1,3", 10),
            arrayOf("1,2,3", 27),
            arrayOf("2,3,1", 78),
            arrayOf("3,2,1", 438),
            arrayOf("3,1,2", 1836)
        )
    }

    @Test
    fun testPartOne() {
        assertThat(day.solveFor2020(numbers), `is`(number))
    }
}

@RunWith(Parameterized::class)
class Day15ParameterizedPartTwo(private val numbers: String, private val number: Int) {
    private val day = Day15()

    companion object {
        @JvmStatic
        @Parameters
        fun data() = listOf(
            arrayOf("0,3,6", 175594),
            arrayOf("1,3,2", 2578),
            arrayOf("2,1,3", 3544142),
            arrayOf("1,2,3", 261214),
            arrayOf("2,3,1", 6895259),
            arrayOf("3,2,1", 18),
            arrayOf("3,1,2", 362)
        )
    }

    @Test
    @Ignore
    fun testPartTwo() {
        assertThat(day.solveFor30000000(numbers), `is`(number))
    }
}