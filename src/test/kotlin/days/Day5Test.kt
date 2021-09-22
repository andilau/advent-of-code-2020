package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day5Test {
    private val day = Day5()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        BoardingPass.parse("BFFFBBFRRR").getSeatId()
        assertThat(day.partOne(), `is`(820))
    }
}
