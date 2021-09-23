package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day4Test {
    private val day = Day4()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(3)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(3)
    }
}
