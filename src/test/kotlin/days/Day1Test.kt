package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {
    private val dayOne = Day1()

    @Test
    @DisplayName("Part 1")
    fun testPart1() {
        assertThat(dayOne.partOne()).isEqualTo(514_579)
    }

    @Test
    @DisplayName("Part 2")
    fun testPart2() {
        assertThat(dayOne.partTwo()).isEqualTo(241_861_950)
    }
}