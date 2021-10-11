package days

@AdventOfCodePuzzle(
    name = "Handheld Halting",
    url = "https://adventofcode.com/2020/day/8",
    date = Date(day = 8, year = 2020)
)
class Day8 : Day(8) {
    private val program = inputList.map { Instruction.of(it) }

    override fun partOne(): Int {
        return try {
            Computer.run(program)
        } catch (e: Computer.InfiniteLoopException) {
            e.acc
        }
    }

    override fun partTwo(): Int {
        for ((index, instruction) in program.withIndex()) {
            val newProgram = program.toMutableList()
            when (instruction.op) {
                "acc" -> continue
                "nop" -> newProgram[index] = instruction.copy(op = "jmp")
                "jmp" -> newProgram[index] = instruction.copy(op = "nop")
            }
            try {
                return Computer.run(newProgram)
            } catch (e: Computer.InfiniteLoopException) {
            }
        }
        return 0
    }

    object Computer {

        fun run(program: List<Instruction>): Int {
            var ip = 0
            var acc = 0
            val seen = mutableSetOf<Int>()

            while (ip < program.size) {
                if (ip in seen) throw InfiniteLoopException(acc)
                seen += ip

                val instruction = program[ip]
                when (instruction.op) {
                    "nop" -> ip++
                    "jmp" -> ip += instruction.num
                    "acc" -> {
                        acc += instruction.num
                        ip++
                    }
                }
            }
            return acc
        }

        class InfiniteLoopException(val acc: Int) : Exception()
    }

    data class Instruction(val op: String, val num: Int) {
        companion object {
            fun of(line: String): Instruction =
                Instruction(
                    line.substringBefore(" "),
                    line.substringAfter(" ").toInt()
                )
        }
    }
}