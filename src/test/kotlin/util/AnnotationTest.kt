package util

import days.AdventOfCodePuzzle
import days.Day
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.reflections.Reflections

class AnnotationTest {
    private val days = Reflections("days").getSubTypesOf(Day::class.java)

    @Test
    @DisplayName("Read Annotations")
    internal fun testAnnotations() {
        val number = Regex("""(\d+)""")
        days
            .sortedBy { (number.find(it.simpleName)?.value)?.toIntOrNull() }
            .map { dayClass ->
                dayClass.getDeclaredAnnotationsByType(AdventOfCodePuzzle::class.java).iterator().forEach {
                    println("${it.name} ${it.url} ${it.date.day}.${it.date.month}.${it.date.year}")
                }
            }
            .also { println("it.size = ${it.size}") }
    }

    private fun foo(dayClass: Class<out Day>) {
        // val value: KFunction1<Array<Class<*>>, Constructor<Class<out Day>>> = dayClass.javaClass::getConstructor
        val kFunction0 = dayClass.getConstructor().newInstance()::partOne
        val kFunction1 = dayClass.getConstructor().newInstance()::partTwo
        dayClass.getDeclaredConstructor()
        println("kFunction0 = ${kFunction0}")
        println("kFunction1 = ${kFunction1}")
        dayClass.constructors.forEach { constructor ->
            print("${constructor.parameterCount} -> ")
            println("constructor = ${constructor.parameterTypes}")
            //constructor.parameterTypes.iterator().forEach { c -> println("c.name = ${c.name}")}
            constructor.genericParameterTypes.iterator().forEach { c -> println("c.name = ${c.typeName}") }
        }
    }
}