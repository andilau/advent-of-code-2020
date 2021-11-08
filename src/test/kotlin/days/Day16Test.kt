package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {
    private val example1 = """
        class: 1-3 or 5-7
        row: 6-11 or 33-44
        seat: 13-40 or 45-50
        
        your ticket:
        7,1,14
        
        nearby tickets:
        7,3,47
        40,4,50
        55,2,20
        38,6,12
        """.trimIndent().lines()

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day16(example1).partOne()).isEqualTo(71)
    }

    private val example2 = """
        class: 0-1 or 4-19
        departure row: 0-5 or 8-19
        departure seat: 0-13 or 16-19
        
        your ticket:
        11,12,13
        
        nearby tickets:
        3,9,18
        15,1,5
        5,14,9
        """.trimIndent().lines()

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day16(example2).partTwo()).isEqualTo(13L)
    }
}