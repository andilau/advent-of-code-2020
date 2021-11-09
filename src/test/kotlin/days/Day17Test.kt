package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 17")
class Day17Test {
    private val plane = """
        .#.
        ..#
        ###
        """.trimIndent().lines()

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day17(plane).partOne()).isEqualTo(112)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day17(plane).partTwo()).isEqualTo(848)
    }
}