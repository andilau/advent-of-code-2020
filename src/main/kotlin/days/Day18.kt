package days

@AdventOfCodePuzzle(
    name = "Operation Order",
    url = "https://adventofcode.com/2020/day/18",
    date = Date(day = 18, year = 2020)
)
class Day18(val lines: List<String>) : Day() {
    override fun partOne() = lines.sumOf { equation ->
        solve(equation, Day18::solveFromLeft)
    }

    override fun partTwo() = lines.sumOf { equation ->
        solve(equation, Day18::solveAddFirst)
    }

    internal fun testPartOne(equation: String): Long = solve(equation, ::solveFromLeft)

    internal fun testPartTwo(equation: String): Long = solve(equation, ::solveAddFirst)

    companion object {
        private val regex = Regex("""\(([\s\d+*]+)\)""")
        private val solved = Regex("""^\d+$""")
        private val sumOrProduct = """(\d+)\s*([+*])\s*(\d+)""".toRegex()
        private val operations = listOf<Pair<Regex, (Long, Long) -> Long>>(
            Regex("""(\d+)\s*\+\s*(\d+)""") to { a, b -> a + b },
            Regex("""(\d+)\s*\*\s*(\d+)""") to { a, b -> a * b }
        )

        private fun solve(equation: String, solver: (String) -> String): Long {
            var equationToSolve = "($equation)"
            while (!solved.matches(equationToSolve)) {
                equationToSolve = regex.replace(equationToSolve) {
                    solver(it.groupValues[1])
                }
            }
            return equationToSolve.toLong()
        }

        private fun solveFromLeft(s: String): String {
            var equation = s
            while (!solved.matches(equation)) {
                val find = sumOrProduct.find(equation) ?: break
                val (expr, op1, op, op2) = find.groupValues
                val result = if (op == "+") op1.toLong() + op2.toLong()
                else op1.toLong() * op2.toLong()
                equation = equation.replaceFirst(expr, result.toString())
            }
            return equation
        }

        private fun solveAddFirst(s: String): String {
            var equation = s
            operations.forEach { (regex, operation) ->
                while (true) {
                    val find = regex.find(equation) ?: break
                    val (expr, op1, op2) = find.groupValues
                    val result = operation(op1.toLong(), op2.toLong())
                    equation = equation.replaceFirst(expr, result.toString())
                }
            }
            return equation
        }
    }
}