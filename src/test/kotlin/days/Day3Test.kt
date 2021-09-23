package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day3Test {
    private val daythree = Day3()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(daythree.partOne()).isEqualTo(7)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(daythree.partTwo()).isEqualTo(336L)
    }
}
