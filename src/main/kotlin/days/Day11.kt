package days

typealias Seat = Pair<Int, Int>

@AdventOfCodePuzzle(
    name = "Seating System",
    url = "https://adventofcode.com/2020/day/11",
    date = Date(day = 11, year = 2020)
)
class Day11(input: List<String>) : Puzzle {
    private val col = input.first().length
    private val row = input.size
    private val seats: Map<Seat, State> = getSeatPlan(input)
    private lateinit var neighboursOf: Map<Seat, Set<Seat>>
    private lateinit var neighboursSeen: Map<Seat, Set<Seat>>

    override fun partOne(): Int {
        neighboursOf = seats.keys.associateWith { seat ->
            neighbors.map { seat + it }
                .filter { seats.containsKey(it) }
                .toSet()
        }
        return generateSequence(seats) { it.calculateNextAdjacent() }
            .zipWithNext()
            .first { it.first == it.second }
            .first
            .values
            .count { it == State.FULL }
    }

    override fun partTwo(): Int {
        neighboursSeen = seats.keys.associateWith { seat ->
            neighbors.mapNotNull { direction ->
                generateSequence(seat + direction) { it + direction }
                    .takeWhile { isInBounds(it) }
                    .firstOrNull { seats.containsKey(it) }
            }
                .toSet()
        }
        return generateSequence(seats) { it.calculateNextBySeen() }
            .zipWithNext()
            .first { it.first == it.second }
            .first
            .values
            .count { it == State.FULL }
    }

    private fun isInBounds(seat: Seat) =
        seat.first >= 0 && seat.second >= 0 && seat.first <= col && seat.second <= row

    private fun Map<Seat, State>.calculateNextAdjacent(): Map<Seat, State> {
        val next: MutableMap<Seat, State> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = countNeighbors(this, seat)
            next[seat] =
                when {
                    type == State.EMPTY && occupied == 0 -> State.FULL
                    type == State.FULL && occupied >= 4 -> State.EMPTY
                    else -> type
                }
        }
        return next.toMap()
    }

    private fun countNeighbors(seats: Map<Seat, State>, seat: Seat) =
        neighboursOf.getValue(seat)
            .count { seats[it] == State.FULL }

    private fun Map<Seat, State>.calculateNextBySeen(): Map<Seat, State> {
        val next: MutableMap<Seat, State> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = countSeen(this, seat)
            next[seat] =
                when {
                    type == State.EMPTY && occupied == 0 -> State.FULL
                    type == State.FULL && occupied >= 5 -> State.EMPTY
                    else -> type
                }
        }
        return next.toMap()
    }

    private fun countSeen(seats: Map<Seat, State>, seat: Seat) =
        neighboursSeen.getValue(seat)
            .count { seats[it] == State.FULL }

    private fun getSeatPlan(input: List<String>): Map<Seat, State> {
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
        internal val neighbors = listOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
    }

    enum class State {
        EMPTY, FULL
    }
}