package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {
    val input = listOf(1721, 979, 366, 299, 675, 1456)

    @Test
    @DisplayName("Part 1")
    internal fun sampleDataPart1() {
        val answer = Day1(input).partOne()
        assertThat(answer).isEqualTo(514_579)
    }

    @Test
    @DisplayName("Part 2")
    internal fun sampleDataPart2() {
        val answer = Day1(input).partTwo()
        assertThat(answer).isEqualTo(241_861_950)
    }
}