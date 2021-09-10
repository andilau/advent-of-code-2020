package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

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

@RunWith(Parameterized::class)
class Day13ParameterizedTest(private val line: String, private val time: Long) {
    private val day = Day13()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("3,5,13", 24L),
            arrayOf("17,x,13,19", 3417L),
            arrayOf("67,x,7,59,61", 779210L),
            arrayOf("67,7,x,59,61", 1261476L),
            arrayOf("1789,37,47,1889", 1202161486L)
        )
    }

    @Test
    fun testPartTwoSimple() {
        assertThat(day.test(line), `is`(time))
    }
}