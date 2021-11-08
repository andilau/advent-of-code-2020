package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {
    private val lines = """
        mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
        trh fvjkl sbzzf mxmxvkd (contains dairy)
        sqjhc fvjkl (contains soy)
        sqjhc mxmxvkd sbzzf (contains fish)""".trimIndent().lines()

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day21(lines).partOne()).isEqualTo(5)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day21(lines).partTwo()).isEqualTo("mxmxvkd,sqjhc,fvjkl")
    }
}