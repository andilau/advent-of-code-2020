package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {
    private val commands = listOf("F10", "N3", "F7", "R90", "F11")

    private
    val day = Day12(commands)

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(17 + 8)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(214 + 72)
    }
}