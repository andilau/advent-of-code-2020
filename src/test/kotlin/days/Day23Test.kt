package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 23")
class Day23Test {
    private val day = Day23()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo("67384529")
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(149_245_887_792)
    }
}