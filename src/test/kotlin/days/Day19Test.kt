package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day19Test {
    private val day = Day19()

    @Test
    fun testPartOne() = assertThat(day.partOne(), `is`(2))

    @Test
    fun testPartTwo() = assertThat(day.partOne(), `is`(2))

    @Test
    fun testOkayMessages1() {
        assertThat(day.match("ababbb"), `is`(true))
    }

    @Test
    fun testOkayMessages2() {
        assertThat(day.match("abbbab"), `is`(true))
    }

    @Test
    fun testNotOkayMessages1() {
        assertThat(day.match("bababa"), `is`(false))
    }

    @Test
    fun testNotOkayMessages2() {
        assertThat(day.match("aaabbb"), `is`(false))
    }

    @Test
    fun testNotOkayMessages3() {
        assertThat(day.match("aaaabbb"), `is`(false))
    }
}