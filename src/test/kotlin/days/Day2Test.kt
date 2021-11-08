package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day2Test {
    private val input = listOf(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"
    )

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(Day2(input).partOne()).isEqualTo(2)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(Day2(input).partTwo()).isEqualTo(1)
    }
}
