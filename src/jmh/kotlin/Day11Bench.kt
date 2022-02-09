package days

import org.openjdk.jmh.annotations.*

@State(Scope.Benchmark)
@BenchmarkMode(Mode.SingleShotTime)
open class Day11Bench {
    private lateinit var lines: List<String>

    @Setup
    fun prepare() {
        lines =
            javaClass.classLoader.getResourceAsStream("input_day_11.txt").bufferedReader().readLines()
    }

    @Benchmark
    fun part1(): Int = Day11(lines).partOne()

    @Benchmark
    fun part2(): Int = Day11(lines).partTwo()
}