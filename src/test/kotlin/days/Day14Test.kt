package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {
    private val day = Day14()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(51L))
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(208L))
    }
}