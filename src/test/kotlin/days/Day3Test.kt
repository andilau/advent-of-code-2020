package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day3Test {
    private val daythree = Day3()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(daythree.partOne(), `is`(7))
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(daythree.partTwo(), `is`(336L))
    }
}
