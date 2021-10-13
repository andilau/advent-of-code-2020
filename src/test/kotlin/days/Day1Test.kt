package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {
    private val dayOne = Day1()

    @Test
    @DisplayName("Part 1")
    fun testPart1() {
        assertThat(dayOne.partOne()).isEqualTo(514_579)
    }

    @DisplayName("Part 2")
    @Nested
    inner class Part2 {
        @Test
        fun testPart2() {
            assertThat(dayOne.partTwo()).isEqualTo(241_861_950)
        }
    }
}