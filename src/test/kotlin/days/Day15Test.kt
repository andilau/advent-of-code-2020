package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 15")
class Day15Test {
    private val day = Day15()

    @DisplayName("Part 1")
    @Nested
    inner class Part1 {
        @Test
        fun testPartOne() {
            assertThat(day.partOne()).isEqualTo(436)
        }

        @Test
        fun testPartFor10() {
            assertThat(day.elementInVanEckSequenceAt("0,3,6",10)).isEqualTo(0)
        }

        @TestFactory
        fun testPartOneFactory() = listOf(
            "0,3,6" to 436,
            "1,3,2" to 1,
            "2,1,3" to 10,
            "1,2,3" to 27,
            "2,3,1" to 78,
            "3,2,1" to 438,
            "3,1,2" to 1836
        ).map { (input, expected) ->
            DynamicTest.dynamicTest("starting with $input should result in element $expected") {
                Assertions.assertEquals(expected, day.elementInVanEckSequenceAt(input, 2020))
            }
        }
    }

    @DisplayName("Part 2")
    @Nested
    inner class Part2 {
        @Test
        fun testPartTwo() {
            assertThat(day.partTwo()).isEqualTo(175_594)
        }

        @TestFactory
        @Disabled
        fun testPartTwoFactory() = listOf(
            "0,3,6" to 175594,
            "1,3,2" to 2578,
            "2,1,3" to 3544142,
            "1,2,3" to 261214,
            "2,3,1" to 6895259,
            "3,2,1" to 18,
            "3,1,2" to 362
        ).map { (input, expected) ->
            DynamicTest.dynamicTest("when I start with $input then I get $expected") {
                Assertions.assertEquals(expected, day.elementInVanEckSequenceAt(input, 30_000_000))
            }
        }
    }
}