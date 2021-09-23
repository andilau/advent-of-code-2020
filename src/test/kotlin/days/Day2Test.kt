package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day2Test {
    private val dayTwo = Day2()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(dayTwo.partOne()).isEqualTo(2)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(dayTwo.partTwo()).isEqualTo(1)
    }
}
