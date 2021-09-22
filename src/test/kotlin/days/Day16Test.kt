package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day16Test {
    private val day = Day16()

    @Test
    fun testPartOne() = assertThat(day.partOne(), `is`(71))
}