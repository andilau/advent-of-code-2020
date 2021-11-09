import days.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import util.InputReader

@DisplayName("Advent of Code solutions")
class SolutionsTest {
    @TestFactory
    fun testAdventOfCode() = listOf(
        Day1(InputReader.getInputAsListOfInt(1)) to Pair(1_007_331, 48_914_340),
        Day2(InputReader.getInputAsList(2)) to Pair(398, 562),
        Day3(InputReader.getInputAsList(3)) to Pair(244, 9_406_609_920),
        Day4(InputReader.getInputAsString(4)) to Pair(242, 186),
        Day5(InputReader.getInputAsList(5)) to Pair(970, 587),
        Day6(InputReader.getInputAsString(6)) to Pair(6542, 3299),
        Day7(InputReader.getInputAsList(7)) to Pair(268, 7867),
        Day8(InputReader.getInputAsList(8)) to Pair(1584, 920),
        Day9(InputReader.getInputAsListOfLong(9)) to Pair(258_585_477L, 36_981_213L),
        Day10(InputReader.getInputAsListOfInt(10)) to Pair(2812, 386_869_246_296_064L),
        Day11(InputReader.getInputAsList(11)) to Pair(2412, 2176),
        Day12(InputReader.getInputAsList(12)) to Pair(2228, 42908),
        Day13(InputReader.getInputAsList(13)) to Pair(207, 530015546283687),
        Day14(InputReader.getInputAsList(14)) to Pair(14553106347726, 2737766154126),
        Day15(InputReader.getInputAsString(15)) to Pair(694, 21768614),
        Day16(InputReader.getInputAsList(16)) to Pair(20091, 2325343130651),
        Day17(InputReader.getInputAsList(17)) to Pair(362, 1980),
        Day18(InputReader.getInputAsList(18)) to Pair(202553439706, 88534268715686),
        Day19(InputReader.getInputAsList(19)) to Pair(279, 384),
        Day20(InputReader.getInputAsString(20)) to Pair(17_250_897_231_301, 1576),
        Day21(InputReader.getInputAsList(21)) to Pair(2203, "fqfm,kxjttzg,ldm,mnzbc,zjmdst,ndvrq,fkjmz,kjkrm"),
        Day22(InputReader.getInputAsList(22)) to Pair(31308, 33647),
        Day23(InputReader.getInputAsString(23)) to Pair("69852437", 91408386135),
        Day24(InputReader.getInputAsList(24)) to Pair(339, 3794),
        Day25(InputReader.getInputAsListOfInt(25)) to Pair(6408263L, 6408263L),
    )
        .map { (day, answers) ->
            DynamicTest.dynamicTest("${day.javaClass.simpleName} -> ${answers.first} / ${answers.second}") {
                assertThat(day.partOne()).isEqualTo(answers.first)
                assertThat(day.partTwo()).isEqualTo(answers.second)
            }
        }
}