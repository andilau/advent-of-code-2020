package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day6Test {
    private val day = Day6()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(11)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(6)
    }
}