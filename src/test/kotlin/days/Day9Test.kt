package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 9")
class Day9Test {
    private val day = Day9()

    init {
        day.preambleSize = 5
    }

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(127)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(62)
    }
}