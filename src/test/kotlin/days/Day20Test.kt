package days

import days.Day20.Tile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day20Test {
    private val day = Day20()

    @Test
    fun testPartOne() {
        assertThat(day.partOne()).isEqualTo(20_899_048_083_289)
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo()).isEqualTo(273)
    }

    @DisplayName("Tile Test")
    @Nested
    inner class TileTest {
        private val tileRotated = Tile(0, "gda, heb, ifc".split(", "))
        private val tileFlipped = Tile(0, "cba, fed, ihg".split(", "))

        @Test
        fun shouldRotate() {
            val tile = Tile(0, "abc\ndef\nghi".lines())
            assertThat(tile.rotate()).isEqualTo(tileRotated)
        }

        @Test
        fun shouldRotateToSelf() {
            val original = Tile(0, "abc\ndef\nghi".lines())
            var tile = original.copy()
            repeat(4) { tile = tile.rotate() }
            assertThat(tile).isEqualTo(original)
        }

        @Test
        fun shouldFlip() {
            val tile = Tile(0, "abc\ndef\nghi".lines())
            assertThat(tile.flip()).isEqualTo(tileFlipped)
        }

        @Test
        fun shouldFlipToSelf() {
            val original = Tile(0, "abc\ndef\nghi".lines())
            var tile = original.copy()
            repeat(2) { tile = tile.flip() }
            assertThat(tile).isEqualTo(original)
        }

        @Test
        fun variations() {
            val tile = Tile(0, "abc\ndef\nghi".lines())
            tile.allVariations().forEach { println(it) }
            assertThat(tile.allVariations().toList())
                .isNotEmpty
                .hasSize(8)
                .doesNotHaveDuplicates()
                .contains(tile)
        }
    }
}