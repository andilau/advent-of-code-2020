package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.*

@DisplayName("Day 13")
class Day13Test {
    private val day = Day13()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(5 * 59))
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(1068781L))
    }

    @TestFactory
    fun testPartTwoSimple() = listOf(
        "3,5,13" to 24L,
        "17,x,13,19" to 3417L,
        "67,x,7,59,61" to 779210L,
        "67,7,x,59,61" to 1261476L,
        "1789,37,47,1889" to 1202161486L
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("when I start with $input then I get $expected") {
            Assertions.assertEquals(expected, day.test(input))
        }
    }

}
