package days

import kotlin.math.absoluteValue

class Day12 : Day(12) {
    override fun partOne(): Any {
        val ship = Ship(Point(0, 0), Heading.EAST)

        inputList.forEach { instruction ->
            val command = instruction.first()
            val value = instruction.drop(1).toInt()
            when (command) {
                'N' -> ship.move(Heading.NORTH, value)
                'S' -> ship.move(Heading.SOUTH, value)
                'E' -> ship.move(Heading.EAST, value)
                'W' -> ship.move(Heading.WEST, value)
                'F' -> ship.forward(value)
                'L' -> ship.turnLeft(value / 90)
                'R' -> ship.turnRight(value / 90)
                else -> throw IllegalArgumentException("unhandled command: $command")
            }
        }
        return ship.manhattanDistanceTo(Point(0, 0))
    }

    override fun partTwo(): Any {
        val ship = Ship(Point(0, 0), Heading.EAST)
        val waypoint = Waypoint(Point(10, 1))

        inputList.forEach { instruction ->
            val command = instruction.first()
            val amount = instruction.drop(1).toInt()
            when (command) {
                'N' -> waypoint.move(Heading.NORTH, amount)
                'S' -> waypoint.move(Heading.SOUTH, amount)
                'E' -> waypoint.move(Heading.EAST, amount)
                'W' -> waypoint.move(Heading.WEST, amount)
                'F' -> ship.moveWith(amount * waypoint.at)
                'L' -> waypoint.turnLeft(amount / 90)
                'R' -> waypoint.turnRight(amount / 90)
                else -> throw IllegalArgumentException("unhandled command: $command")
            }
        }
        return ship.manhattanDistanceTo(Point(0, 0))
    }

    data class Waypoint(var at: Point) {
        fun move(heading: Heading, value: Int) {
            at = at + (value * heading.offset)
        }

        fun turnLeft(times: Int) {
            at = (0 until times).fold(at) { point, _ -> point.rotateLeft() }
        }

        fun turnRight(times: Int) {
            at = (0 until times).fold(at) { point, _ -> point.rotateRight() }
        }
    }

    data class Ship(var at: Point = Point(0, 0), var direction: Heading = Heading.EAST) {
        fun move(heading: Heading, value: Int) {
            at = at + (value * heading.offset)
        }

        fun moveWith(point: Point) {
            at = at + point
        }

        fun forward(value: Int) {
            at = at + (value * direction.offset)
        }

        fun turnRight(times: Int) {
            direction = direction.turnRight(times)
        }

        fun turnLeft(times: Int) {
            direction = direction.turnLeft(times)
        }

        fun manhattanDistanceTo(point: Point): Int {
            return (at.first - point.first).absoluteValue +
                    (at.second - point.second).absoluteValue
        }
    }

    enum class Heading(val offset: Point) {
        NORTH(Point(0, 1)),
        EAST(Point(1, 0)),
        SOUTH(Point(0, -1)),
        WEST(Point(-1, 0));

        fun turnRight(times: Int) = enumValues<Heading>()[(ordinal + times) % values().size]

        fun turnLeft(times: Int) = turnRight(values().size - times)
    }
}