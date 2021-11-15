package util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Input Reader")
class InputReaderTest {
    @Test
    fun testReadInputAsString() {
        val input = InputReader.getInputAsString(0)
        assertThat(input).isEqualTo("1721\n979\n366\n299\n675\n1456")
    }

    @Test
    fun testReadInputAsList() {
        val input = InputReader.getInputAsList(0)
        assertThat(input)
            .isNotEmpty
            .hasSize(6)
            .containsExactly("1721", "979", "366", "299", "675", "1456")
    }

    @Test
    fun testReadInputAsListOfInt() {
        val input = InputReader.getInputAsListOfInt(0)
        assertThat(input)
            .isNotEmpty
            .hasSize(6)
            .containsExactly(1721, 979, 366, 299, 675, 1456)
    }

    @Test
    fun testReadInputAsListOfLong() {
        val input = InputReader.getInputAsListOfLong(0)
        assertThat(input)
            .isNotEmpty
            .hasSize(6)
            .containsExactly(1721L, 979L, 366L, 299L, 675L, 1456L)
    }

    @Test
    fun testFailMissingFile() {
        assertThatThrownBy {
            InputReader.getInputAsString(99)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}