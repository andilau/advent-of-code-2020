package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 25")
class Day25Test {
    private val day = Day25()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(14_897_079)
    }
}