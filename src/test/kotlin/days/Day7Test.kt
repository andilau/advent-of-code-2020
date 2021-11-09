package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day7Test {
    val lines = """light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.""".lines()

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(
            Day7(

                lines
            ).partOne()
        ).isEqualTo(4)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(
            Day7(

                lines
            ).partTwo()
        ).isEqualTo(32)
    }
}