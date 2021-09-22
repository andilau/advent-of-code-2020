package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {
    private val day = Day16()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() = assertThat(day.partOne(), `is`(71))
}