package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day13Test {
    private val day = Day13()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(5 * 59))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(1068781L))
    }
}

class Day13ParameterizedTest {
    private val day = Day13()

    companion object {
        @JvmStatic
        fun data(): List<Arguments> = listOf(
            Arguments.of("3,5,13", 24L),
            Arguments.of("17,x,13,19", 3417L),
            Arguments.of("67,x,7,59,61", 779210L),
            Arguments.of("67,7,x,59,61", 1261476L),
            Arguments.of("1789,37,47,1889", 1202161486L)
        )
    }

    @ParameterizedTest
    @MethodSource("data")
    fun testPartTwoSimple(line: String, time: Long) {
        assertThat(day.test(line), `is`(time))
    }
}