package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day3Test {
    private val input = listOf(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#"
    )

    @Test
    @DisplayName("Part 1")
    fun testPartOne() {
        assertThat(Day3(input).partOne()).isEqualTo(7)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(Day3(input).partTwo()).isEqualTo(336L)
    }
}
