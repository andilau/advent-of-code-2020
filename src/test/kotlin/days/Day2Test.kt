package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day2Test {
    private val dayTwo = Day2()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(dayTwo.partOne(), `is`(2))
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(dayTwo.partTwo(), `is`(1))
    }
}
