package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day5Test {
    private val day = Day5()

    @Test
    fun testPartOne() {
        BoardingPass.parse("BFFFBBFRRR").getSeatId()
        assertThat(day.partOne(), `is`(820))
    }
}
