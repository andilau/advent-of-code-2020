package days

typealias Seat = Pair<Int, Int>
typealias Seats = Map<Seat, Day11.State>
typealias SeatsMapNeighbours = Map<Seat, Set<Seat>>

@AdventOfCodePuzzle(
    name = "Seating System",
    url = "https://adventofcode.com/2020/day/11",
    date = Date(day = 11, year = 2020)
)
class Day11(input: List<String>) : Puzzle {
    private val col = input.first().length
    private val row = input.size
    private val seats: Seats = getSeats(input)

    override fun partOne(): Int {
        return generateStableMap(seats.getMapSeatsToNeighboursNear(), 4).occupied()
    }

    override fun partTwo(): Int {
        return generateStableMap(seats.getMapSeatsToNeighboursSight(), 5).occupied()
    }

    private fun generateStableMap(map: SeatsMapNeighbours, limit: Int) =
        generateSequence(seats) { it.generateNext(map, limit) }
            .zipWithNext()
            .first { it.first == it.second }
            .first

    private fun Seats.getMapSeatsToNeighboursNear() =
        keys.associateWith { seat ->
            neighbors.map { seat + it }
                .filter { containsKey(it) }
                .toSet()
        }

    private fun Seats.getMapSeatsToNeighboursSight() =
        keys.associateWith { seat ->
            neighbors.mapNotNull { direction ->
                generateSequence(seat + direction) { it + direction }
                    .takeWhile { it.inBounds() }
                    .firstOrNull { containsKey(it) }
            }
                .toSet()
        }

    private fun Seat.inBounds() =
        (first in 0..col) && (second in 0..row)

    private fun Seats.generateNext(
        mapSeatsToNeighbours: Map<Seat, Set<Seat>>,
        limit: Int
    ): Seats {
        val next: MutableMap<Seat, State> = mutableMapOf()
        for (seat in keys) {
            val type = getValue(seat)
            val occupied = this.countNeighbors(mapSeatsToNeighbours, seat)
            next[seat] =
                when {
                    type == State.EMPTY && occupied == 0 -> State.OCCUPIED
                    type == State.OCCUPIED && occupied >= limit -> State.EMPTY
                    else -> type
                }
        }
        return next.toMap()
    }

    private fun Seats.occupied() =
        values.count { it == State.OCCUPIED }

    private fun Seats.countNeighbors(map: SeatsMapNeighbours, seat: Seat) =
        map.getValue(seat)
            .count { this[it] == State.OCCUPIED }

    private fun getSeats(input: List<String>): Seats {
        val seats: MutableMap<Seat, State> = mutableMapOf()
        for ((y, line) in input.withIndex()) {
            line.indices.map { x ->
                if (line[x] == State.EMPTY.char) seats[x to y] = State.EMPTY
            }
        }
        return seats
    }

    private operator fun Seat.plus(that: Seat): Seat =
        Seat(this.first + that.first, this.second + that.second)

    companion object {
        private val neighbors = sequenceOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
    }

    enum class State(val char: Char) {
        EMPTY('L'), OCCUPIED('#')
    }
}