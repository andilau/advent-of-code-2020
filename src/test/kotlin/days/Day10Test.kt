package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {
    private val day = Day10()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(5 * 7))
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(8L))
    }
}