package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Ignore
import org.junit.Test
import java.math.BigInteger

class Day5Test {
    private val day = Day5()

//    BFFFBBFRRR: row 70, column 7, seat ID 567.
//    FFFBBBFRRR: row 14, column 7, seat ID 119.
//    BBFFBBFRLL: row 102, column 4, seat ID 820.

    @Test
    fun testPartOne() {
        BoardingPass.parse("BFFFBBFRRR").getSeatId()
        assertThat(day.partOne(), `is`(820))
    }

    @Test
    @Ignore
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(0))
    }
}
