package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 25")
class Day25Test {
    val input = listOf(5764801, 17807724)

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day25(input).partOne()).isEqualTo(14_897_079)
    }
}