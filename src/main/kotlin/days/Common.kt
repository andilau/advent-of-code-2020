package days

typealias Point = Pair<Int, Int>

operator fun Point.plus(other: Point) =
    Point(first + other.first, second + other.second)

operator fun Point.minus(other: Point) =
    Point(first - other.first, second - other.second)

fun Point.rotateLeft() = Point(-second, first)

fun Point.rotateRight() = Point(second, -first)

operator fun Int.times(offset: Point) =
    Point(this * offset.first, this * offset.second)