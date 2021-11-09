package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {
    private val example1 = listOf(
        "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
        "mem[8] = 11",
        "mem[7] = 101",
        "mem[8] = 0"
    )

    @Test
    @DisplayName("Part 1")
    fun testPartOneExample1() {
        assertThat(Day14(example1).partOne()).isEqualTo(165L)
    }

    private val example2 = listOf(
        "mask = 000000000000000000000000000000X1001X",
        "mem[42] = 100",
        "mask = 00000000000000000000000000000000X0XX",
        "mem[26] = 1"
    )

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day14(example2).partTwo()).isEqualTo(208L)
    }
}