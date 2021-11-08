package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 22")
class Day22Test {
    private val lines = """
        Player 1:
        9
        2
        6
        3
        1
        
        Player 2:
        5
        8
        4
        7
        10
        """.trimIndent().lines()

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day22(lines).partOne()).isEqualTo(306)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day22(lines).partTwo()).isEqualTo(291)
    }
}