package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day5Test {
    val input = listOf(
        "BFFFBBFRRR",
        "FFFBBBFRRR",
        "BBFFBBFRLL"
    )

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day5(input).partOne()).isEqualTo(820)
    }
}
