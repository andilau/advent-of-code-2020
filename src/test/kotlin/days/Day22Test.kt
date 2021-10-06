package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 22")
class Day22Test {
    private val day = Day22()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(306)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(291)
    }
}