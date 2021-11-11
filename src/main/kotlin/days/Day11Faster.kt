package days

import days.Day11Faster.State.*

@AdventOfCodePuzzle(
    name = "Seating System",
    url = "https://adventofcode.com/2020/day/11",
    date = Date(day = 11, year = 2020)
)
class Day11Faster(input: List<String>) : Puzzle {
    private val initialSeats: Map<Seat, State> = getSeatPlan(input)

    override fun partOne(): Int = generateSequence(initialSeats) { it.calculateNextAdjacent() }
        .zipWithNext()
        .first { it.first == it.second }
        .first
        .values
        .count { it == FULL }

    override fun partTwo(): Int = generateSequence(initialSeats) { it.calculateNextBySeen() }
        .zipWithNext()
        .first { it.first == it.second }
        .first
        .values
        .count { it == FULL }

    private fun getSeatPlan(input: List<String>): Map<Seat, State> {
        val seats: MutableMap<Seat, State> = mutableMapOf()
        for ((y, line) in input.withIndex()) {
            line.indices.map { x ->
                seats[x to y] = when {
                    line[x] == 'L' -> EMPTY
                    line[x] == '.' -> NONE
                    else -> error("Unknown seat type ${line[x]}")
                }
            }
        }
        return seats
    }

    private fun countNeighbors(seats: Map<Seat, State>, seat: Seat) =
        neighbors
            .map { it + seat }
            .filter { it in seats.keys }
            .count { seats[it] == FULL }

    private fun countNeighborsSeen(seats: Map<Seat, State>, seat: Seat): Int {
        return neighbors
            .map { direction -> findSeatsInDirection(seats, seat, direction) }
            .count { it == FULL }
    }

    private fun findSeatsInDirection(seats: Map<Pair<Int, Int>, State>, seat: Seat, direction: Seat): State? =
        generateSequence(seat + direction) { it + direction }
            .takeWhile { it in seats.keys }
            .map { seats[it] } // values null, 'L' or '#'
            .firstOrNull { it != NONE }

    private operator fun Seat.plus(that: Seat): Seat =
        Seat(this.first + that.first, this.second + that.second)

    private fun Map<Seat, State>.calculateNextAdjacent(): Map<Seat, State> {
        val new: MutableMap<Seat, State> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = countNeighbors(this, seat)
            new[seat] =
                when {
                    type == EMPTY && occupied == 0 -> FULL
                    type == FULL && occupied >= 4 -> EMPTY
                    else -> type
                }
        }
        return new.toMap()
    }

    private fun Map<Seat, State>.calculateNextBySeen(): Map<Seat, State> {
        val next: MutableMap<Seat, State> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = countNeighborsSeen(this, seat)
            next[seat] =
                when {
                    type == EMPTY && occupied == 0 -> FULL
                    type == FULL && occupied >= 5 -> EMPTY
                    else -> type
                }
        }
        return next.toMap()
    }

    companion object {
        internal val neighbors = listOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
    }

    enum class State {
        NONE, EMPTY, FULL
    }
}