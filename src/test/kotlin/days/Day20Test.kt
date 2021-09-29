package days

import days.Day20.Tile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {
    private val day = Day20()

    @DisplayName("Part 1")
    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(20_899_048_083_289)
    }

    @Test
    @DisplayName("Part 2")
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(273)
    }

    @DisplayName("Tile Test")
    @Nested
    inner class TileTest {
        private val original = Tile(0, "abc\ndef\nghi".lines())
        private val tileRotated = Tile(0, "gda\nheb\nifc".lines())
        private val tileFlipped = Tile(0, "cba\nfed\nihg".lines())

        @Test
        fun shouldRotate() {
            assertThat(original.rotate()).isEqualTo(tileRotated)
        }

        @Test
        fun shouldRotateToSelf() {
            var tile = original.copy()
            repeat(4) { tile = tile.rotate() }
            assertThat(tile).isEqualTo(original)
        }

        @Test
        fun shouldFlip() {
            assertThat(original.flip()).isEqualTo(tileFlipped)
        }

        @Test
        fun shouldFlipToSelf() {
            var tile = original.copy()
            repeat(2) { tile = tile.flip() }
            assertThat(tile).isEqualTo(original)
        }

        @Test
        fun variations() {
            val tile = Tile(0, "abc\ndef\nghi".lines())
            assertThat(tile.allVariations().toList())
                .isNotEmpty
                .hasSize(8)
                .doesNotHaveDuplicates()
                .contains(tile)
        }
    }
}