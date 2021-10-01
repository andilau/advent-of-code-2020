package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {
    private val day = Day21()

    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(5)
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo("mxmxvkd,sqjhc,fvjkl")
    }
}