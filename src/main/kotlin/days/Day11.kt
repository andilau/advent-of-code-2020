package days

typealias Seat = Pair<Int, Int>

@AdventOfCodePuzzle(
    name = "Seating System",
    url = "https://adventofcode.com/2020/day/11",
    date = Date(day = 11, year = 2020)
)
class Day11(input: List<String>) : Day() {
    private val initialSeats: Map<Seat, Char> = getSeatPlan(input)

    private val neighbors = listOf(
        -1 to -1, -1 to 0, -1 to 1,
        0 to -1, 0 to 1,
        1 to -1, 1 to 0, 1 to 1
    )

    override fun partOne(): Int = generateSequence(initialSeats) { it.calculateNext() }
        .zipWithNext()
        .first { it.first == it.second }
        .first
        .values
        .count { it == '#' }

    override fun partTwo(): Int = generateSequence(initialSeats) { it.calculateNext2() }
        .zipWithNext()
        .first { it.first == it.second }
        .first
        .values
        .count { it == '#' }

    private fun getSeatPlan(input: List<String>): Map<Seat, Char> {
        val seats: MutableMap<Seat, Char> = mutableMapOf()
        for ((y, line) in input.withIndex()) {
            line.indices.map { x ->
                seats[x to y] = line[x]
            }
        }
        return seats
    }

    private fun countNeighbors(seats: Map<Seat, Char>, seat: Seat) =
        neighbors
            .map { it + seat }
            .filter { it in seats.keys }
            .count { seats[it] == '#' }

    private fun countNeighborsSeen(seats: Map<Seat, Char>, seat: Seat): Int {
        return neighbors
            .map { findSeatsInDirection(seats, seat, it) }
            .count { it == '#' }
    }

    private fun findSeatsInDirection(seats: Map<Pair<Int, Int>, Char>, seat: Seat, vector: Seat): Char? =
        generateSequence(seat + vector) { it + vector }
            //.filter { seats.containsKey(it) }
            .map { seats[it] }
            .first { it == null || it != '.' }

    private operator fun Seat.plus(that: Seat): Seat =
        Seat(this.first + that.first, this.second + that.second)

    private fun Map<Seat, Char>.calculateNext(): Map<Seat, Char> {
        val new: MutableMap<Seat, Char> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = countNeighbors(this, seat)
            new[seat] =
                when {
                    type == 'L' && occupied == 0 -> '#'
                    type == '#' && occupied >= 4 -> 'L'
                    else -> type
                }
        }
        return new.toMap()
    }

    private fun Map<Seat, Char>.calculateNext2(): Map<Seat, Char> {
        val new: MutableMap<Seat, Char> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = countNeighborsSeen(this, seat)
            new[seat] =
                when {
                    type == 'L' && occupied == 0 -> '#'
                    type == '#' && occupied >= 5 -> 'L'
                    else -> type
                }
        }
        return new.toMap()
    }
}