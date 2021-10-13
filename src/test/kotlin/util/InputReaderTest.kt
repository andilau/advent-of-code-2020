package util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Input Reader")
class InputReaderTest {
    @Test
    fun testReadInputAsString() {
        val testInputAsString = InputReader.getInputAsString(1)
        assertThat(testInputAsString).isEqualTo("1721\n979\n366\n299\n675\n1456")
    }

    @Test
    fun testReadInputAsList() {
        val testInputAsList = InputReader.getInputAsList(1)
        assertThat(testInputAsList)
            .isNotEmpty
            .hasSize(6)
            .containsExactly("1721", "979", "366", "299", "675", "1456")
    }

    @Test
    fun testFailMissingFile() {
        assertThatThrownBy {
            InputReader.getInputAsString(0)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}