package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day6Test {
    val input = """
        abc

        a
        b
        c
        
        ab
        ac
        
        a
        a
        a
        a
        
        b""".trimIndent()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(Day6(input).partOne()).isEqualTo(11)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(Day6(input).partTwo()).isEqualTo(6)
    }
}