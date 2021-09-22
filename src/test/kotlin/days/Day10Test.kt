package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day10Test {
    private val day = Day10()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(5 * 7))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(8L))
    }
}