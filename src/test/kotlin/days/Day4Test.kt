package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day4Test {
    private val day = Day4()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(3))
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(3))
    }
}
