package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day9Test {
    private val day = Day9()

    @Test
    fun testPartOne() {
        day.preambleSize = 5
        assertThat(day.partOne(), `is`(127))
    }

    @Test
    fun testPartTwo() {
        day.preambleSize = 5
        assertThat(day.partTwo(), `is`(62))
    }
}