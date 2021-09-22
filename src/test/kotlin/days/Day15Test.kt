package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class Day15Test {
    private val day = Day15()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(436))
    }

    @Test
    @Disabled
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(175594))
    }
}

class Day15ParameterizedPartOne {
    private val day = Day15()

    companion object {
        @JvmStatic
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

    @ParameterizedTest
    @MethodSource("data")
    fun testPartOne(numbers: String, number: Int) {
        assertThat(day.solveFor2020(numbers), `is`(number))
    }
}

class Day15ParameterizedPartTwo {
    private val day = Day15()

    companion object {
        @JvmStatic
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

    @ParameterizedTest
    @MethodSource("data")
    @Disabled
    fun testPartTwo(numbers: String, number: Int) {
        assertThat(day.solveFor30000000(numbers), `is`(number))
    }
}