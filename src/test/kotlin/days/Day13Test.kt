package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 13")
class Day13Test {
    private val day = Day13(listOf("939", "7,13,x,x,59,x,31,19"))

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(5 * 59)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(1_068_781L)
    }

    @TestFactory
    fun testPartTwoSimple() = listOf(
        "3,5,13" to 24L,
        "17,x,13,19" to 3_417L,
        "67,x,7,59,61" to 779_210L,
        "67,7,x,59,61" to 1_261_476L,
        "1789,37,47,1889" to 1_202_161_486L
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("when I start with $input then I get $expected") {
            Assertions.assertEquals(expected, day.test(input))
        }
    }

}
