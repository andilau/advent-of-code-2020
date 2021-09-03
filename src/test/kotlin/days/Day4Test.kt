package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import java.math.BigInteger

class Day4Test {
    private val day = Day4()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(3))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(3))
    }
}
