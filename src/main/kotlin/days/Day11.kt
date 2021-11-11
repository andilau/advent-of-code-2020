package days

typealias Seat = Pair<Int, Int>
typealias Seats = Map<Seat, Day11.State>

@AdventOfCodePuzzle(
    name = "Seating System",
    url = "https://adventofcode.com/2020/day/11",
    date = Date(day = 11, year = 2020)
)
class Day11(input: List<String>) : Puzzle {
    private val col = input.first().length
    private val row = input.size
    private val seats: Seats = getSeatPlan(input)
    private lateinit var neighboursOf: Map<Seat, Set<Seat>>
    private lateinit var neighboursSeen: Map<Seat, Set<Seat>>

    override fun partOne(): Int {
        neighboursOf = seats.getNeighbours()
        return generateStableMap(this::countNeighbors, 4)
    }

    override fun partTwo(): Int {
        neighboursSeen = seats.getNeighboursSeen()
        return generateStableMap(this::countSeen, 5)
    }

    private fun Seats.getNeighbours() = keys.associateWith { seat ->
        neighbors.map { seat + it }
            .filter { containsKey(it) }
            .toSet()
    }

    private fun Seats.getNeighboursSeen() = keys.associateWith { seat ->
        neighbors.mapNotNull { direction ->
            generateSequence(seat + direction) { it + direction }
                .takeWhile { it.inBounds() }
                .firstOrNull { containsKey(it) }
        }
            .toSet()
    }

    private fun generateStableMap(countFunction: (Map<Seat, State>, Seat) -> Int, limit: Int) =
        generateSequence(seats) { it.calculateNext(countFunction, limit) }
            .zipWithNext()
            .first { it.first == it.second }
            .first
            .values
            .count { it == State.FULL }

    private fun Seat.inBounds() =
        (first in 0..col) && (second in 0..row)

    private fun Seats.calculateNext(
        countOccupied: (Seats, Seat) -> Int,
        limit: Int
    ): Seats {
        val next: MutableMap<Seat, State> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = countOccupied(this, seat)
            next[seat] =
                when {
                    type == State.EMPTY && occupied == 0 -> State.FULL
                    type == State.FULL && occupied >= limit -> State.EMPTY
                    else -> type
                }
        }
        return next.toMap()
    }

    private fun countNeighbors(seats: Seats, seat: Seat) =
        neighboursOf.getValue(seat)
            .count { seats[it] == State.FULL }

    private fun countSeen(seats: Seats, seat: Seat) =
        neighboursSeen.getValue(seat)
            .count { seats[it] == State.FULL }

    private fun getSeatPlan(input: List<String>): Seats {
        val seats: MutableMap<Seat, State> = mutableMapOf()
        for ((y, line) in input.withIndex()) {
            line.indices.map { x ->
                if (line[x] == 'L') seats[x to y] = State.EMPTY
            }
        }
        return seats
    }

    private operator fun Seat.plus(that: Seat): Seat =
        Seat(this.first + that.first, this.second + that.second)

    companion object {
        private val neighbors = listOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
    }

    enum class State { EMPTY, FULL }
}