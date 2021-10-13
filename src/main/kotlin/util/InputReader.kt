package util

import java.io.File
import java.net.URI

object InputReader {
    fun getInputAsString(day: Int): String = File(fromResources(day)).readText()

    fun getInputAsList(day: Int): List<String> = File(fromResources(day)).readLines()

    private fun fromResources(day: Int): URI =
        javaClass.classLoader.getResource("input_day_$day.txt")?.toURI()
            ?: throw IllegalArgumentException("input file for day $day not found")
}
