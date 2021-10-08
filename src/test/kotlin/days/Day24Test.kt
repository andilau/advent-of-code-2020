package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 24")
class Day24Test {
    private val day = Day24()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(10)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(2208)
    }
}