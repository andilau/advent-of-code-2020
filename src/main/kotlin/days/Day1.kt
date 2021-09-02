package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        return inputList
            .map { it.toInt() }
            .findPairOfSum(2020)
            ?.let { (a, b) -> a * b }
            ?: 0
    }

    override fun partTwo(): Any {
        return inputList
            .map { it.toInt() }
            .findTripleOfSum(2020)
            ?.let { (a, b, c) -> a * b * c }
            ?: 0
    }
}

fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    for (first in this)
        for (second in this)
            if (first + second == sum)
                return first to second
    return null
}

fun List<Int>.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? {
    forEach { first ->
        forEach { second ->
            forEach { third ->
                if (first + second + third == sum)
                    return Triple(first, second, third)
            }
        }
    }
    return null
}
