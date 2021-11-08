package util

import days.Day
import org.reflections.Reflections
import kotlin.math.max
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

@ExperimentalTime
object Runner {
    private val dayClasses by lazy {
        Reflections("days").getSubTypesOf(Day::class.java)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val solutions = dayClasses.map { dayNumber(it.simpleName) }.toSet()

        val days: List<Int>? = args
            .map { it.toIntOrNull() ?: error("Day argument must be an integer") }
            .filter { it in solutions || error("No solution for day $it found") }
            .takeIf { it.isNotEmpty() }

        dayClasses
            .sortedBy { dayNumber(it.simpleName) }
            .filter { days == null || dayNumber(it.simpleName) in days }
            .takeIf { it.isNotEmpty() }
            ?.forEach { printDay(it) }
            ?: printError("Days $days not found")
    }

    private fun printDay(dayClass: Class<out Day>) {
        val dayNumber: Int = dayNumber(dayClass.simpleName)
        println("\n=== DAY $dayNumber (${dayClass.simpleName}) ===")

        var day: Day? = null
        try {
            day = dayClass.constructors[0].newInstance() as Day
        } catch (e: IllegalArgumentException) {
            when (dayClass.constructors[0].genericParameterTypes[0].typeName) {
                "java.util.List<java.lang.Integer>" -> {
                    day = dayClass.constructors[0].newInstance(InputReader.getInputAsListOfInt(dayNumber)) as Day
                }
                "java.util.List<java.lang.String>" -> {
                    day = dayClass.constructors[0].newInstance(InputReader.getInputAsList(dayNumber)) as Day
                }
                "java.lang.String" -> {
                    day = dayClass.constructors[0].newInstance(InputReader.getInputAsString(dayNumber)) as Day
                }
            }
        }
        if (day is Day) {
            val partOne = measureTimedValue { day.partOne() }
            val partTwo = measureTimedValue { day.partTwo() }
            printParts(partOne, partTwo)
        }
    }

    private fun printParts(partOne: TimedValue<Any>, partTwo: TimedValue<Any>) {
        val padding = max(
            partOne.value.toString().length,
            partTwo.value.toString().length
        ) + 14        // 14 is 8 (length of 'Part 1: ') + 6 more
        println("Part 1: ${partOne.value}".padEnd(padding, ' ') + "(${partOne.duration})")
        println("Part 2: ${partTwo.value}".padEnd(padding, ' ') + "(${partTwo.duration})")
    }

    private fun printError(message: String) =
        System.err.println("\n=== ERROR ===\n$message")

    private fun dayNumber(dayClassName: String): Int =
        NUMBER_PATTERN.find(dayClassName)?.value?.toIntOrNull() ?: 0
}

private val NUMBER_PATTERN = Regex("""(\d+)""")