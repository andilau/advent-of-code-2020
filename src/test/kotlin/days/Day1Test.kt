package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {
    private val dayOne = Day1()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(514579))
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(dayOne.partTwo(), `is`(241861950))
    }
}
