package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 8")
class Day8Test {
    val lines = """
        nop +0
        acc +1
        jmp +4
        acc +3
        jmp -3
        acc -99
        acc +1
        jmp -4
        acc +6
        """.trimIndent().lines()

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day8(lines).partOne()).isEqualTo(5)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day8(lines).partTwo()).isEqualTo(8)
    }
}