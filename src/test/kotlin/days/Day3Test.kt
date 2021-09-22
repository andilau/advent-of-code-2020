package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day3Test {
    private val daythree = Day3()

    @Test
    fun testPartOne() {
        assertThat(daythree.partOne(), `is`(7))
    }

    @Test
    fun testPartTwo() {
        assertThat(daythree.partTwo(), `is`(336L))
    }
}
