package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 23")
class Day23Test {
    val input = "389125467"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("test partOne after 10 moves")
        internal fun testPartOne10Moves() {
            assertThat(Day23(input).playRoundsAndGetCups(10)).isEqualTo("92658374")
        }

        @Test
        @DisplayName("test PartOne after 100 moves")
        fun testPartOne100Moves() {
            assertThat(Day23(input).partOne()).isEqualTo("67384529")
        }
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day23(input).partTwo()).isEqualTo(149_245_887_792)
    }
}