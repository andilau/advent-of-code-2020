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

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(Day3(input).partOne()).isEqualTo(7)
    }

    @DisplayName("Part 2")
    @Test
    fun testPartTwo() {
        assertThat(Day3(input).partTwo()).isEqualTo(336L)
    }
}
