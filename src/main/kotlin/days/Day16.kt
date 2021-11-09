package days

@AdventOfCodePuzzle(
    name = "Ticket Translation",
    url = "https://adventofcode.com/2020/day/16",
    date = Date(day = 16, year = 2020)
)
class Day16(lines: List<String>) : Puzzle {
    private val rules = lines.takeWhile(String::isNotEmpty).map(TicketRule.Companion::parse)
    private val ownTicket = lines.dropWhile { it != "your ticket:" }.drop(1).first().split(",").map { it.toInt() }
    private val allTickets = lines.dropWhile { it != "nearby tickets:" }.drop(1).map { row ->
        row.split(",").map { it.toInt() }
    }

    override fun partOne(): Int =
        allTickets.sumOf { ticket ->
            ticket.filter { field ->
                rules.none { rule -> rule.isValidValue(field) }
            }.sum()
        }

    override fun partTwo(): Long {
        val validTickets = allTickets.filter { ticket ->
            ticket.all { field ->
                rules.any { rule ->
                    rule.isValidValue(field)
                }
            }
        }

        val validRules: Map<TicketRule, MutableSet<Int>> = rules.associateWith { rule ->
            ownTicket.indices.filter { index ->
                validTickets.all { rule.isValidValue(it[index]) }
            }.toMutableSet()
        }

        val mapping = mutableMapOf<TicketRule, Int>()
        while (validRules.values.any { it.size > 1 }) {
            validRules.entries
                .filter { (_, columns) -> columns.size == 1 }
                .map { (rule, columns) ->
                    val columnIndex = columns.first()
                    validRules.values.forEach { it.remove(columnIndex) }
                    mapping[rule] = columnIndex
                }
        }

        return mapping.entries
            .filter { (rule, _) -> rule.name.startsWith("departure") }
            .map { (_, index) -> ownTicket[index].toLong() }
            .reduce { a, b -> a * b }
    }

    data class TicketRule(val name: String, val firstRange: IntRange, val secondRange: IntRange) {
        // departure location: 31-201 or 227-951
        // departure station: 49-885 or 892-961
        // departure platform: 36-248 or 258-974
        // ...
        companion object {
            fun parse(line: String): TicketRule = TicketRule(
                line.substringBefore(": "),
                line.substringAfter(": ").substringBefore(" or ")
                    .split("-").let { it.first().toInt()..it.last().toInt() },
                line.substringAfter(": ").substringAfter(" or ")
                    .split("-").let { it.first().toInt()..it.last().toInt() }
            )
        }

        fun isValidValue(value: Int) = (value in firstRange) || (value in secondRange)
    }
}
