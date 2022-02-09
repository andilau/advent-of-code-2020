package days

import org.openjdk.jmh.annotations.*

@State(Scope.Benchmark)
@BenchmarkMode(Mode.SingleShotTime)
open class Day1Bench {
    private lateinit var ints: List<Int>

    @Setup
    fun prepare() {
        ints =
            javaClass.classLoader.getResourceAsStream("input_day_1.txt").bufferedReader().readLines().map(String::toInt)
    }

    @Benchmark
    fun part1(): Int = Day1(ints).partOne()

    @Benchmark
    fun part2(): Int = Day1(ints).partTwo()
}