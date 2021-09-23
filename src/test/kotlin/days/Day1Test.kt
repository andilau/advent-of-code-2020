package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {
    private val dayOne = Day1()
    private val input = listOf(1721, 979, 366, 299, 675, 1456)

    @DisplayName("Part 1")
    @Nested
    inner class Part1 {
        @Test
        @Disabled
        fun Example() {
            assertThat(dayOne.partOne()).isEqualTo(514_579)
        }

        @Test
        fun Actual() {
            assertThat(dayOne.partOne()).isEqualTo(1_007_331)
        }
    }

    @DisplayName("Part 2")
    @Nested
    inner class Part2 {
        @Test
        @Disabled
        fun Example() {
            assertThat(dayOne.partTwo()).isEqualTo(241861950)
        }

        @Test
        fun Actual() {
            assertThat(dayOne.partTwo()).isEqualTo(48914340)
        }

    }
}
