package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {
    private val ints = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day10(ints).partOne()).isEqualTo(5 * 7)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day10(ints).partTwo()).isEqualTo(8L)
    }
}