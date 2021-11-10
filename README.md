# Advent of Code 2020: Solutions in Kotlin

My solutions for [Advent of Code 2020](https://adventofcode.com/2020) in the [Kotlin](https://kotlinlang.org/)
programming language. Advent of Code is an Advent calendar of small programming puzzles by [Eric Wastl](http://was.tl/).

## Goals

The solutions posted here are my attempts to learn kotlin by solving puzzles. The main implementation goals were:

- __Readability:__ clean, readable, expressive code
- __Idiomatic:__ concise, functional-style kotlin code
- __Simple:__ single day `class` implementing the `puzzle` interface
- __Minimal:__ shared code (DRY) between the two parts with minimal external dependencies
- __Performance:__ effective algorithms, preferably solving each puzzle in under a second (Intel Core i7@2.6GHz)
  - TODO (~~Day15~~, ~~Day23~~, Day11)

## Solutions

- Day 1: [Report Repair](https://adventofcode.com/2020/day/1) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day1.kt)
- Day 2: [Password Philosophy](https://adventofcode.com/2020/day/2) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day2.kt)
- Day 3: [Toboggan Trajectory](https://adventofcode.com/2020/day/3) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day3.kt)
- Day 4: [Passport Processing](https://adventofcode.com/2020/day/4) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day4.kt)
- Day 5: [Binary Boarding](https://adventofcode.com/2020/day/5) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day5.kt)
- Day 6: [Custom Customs](https://adventofcode.com/2020/day/6) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day6.kt)
- Day 7: [Handy Haversacks](https://adventofcode.com/2020/day/7) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day7.kt)
- Day 8: [Handheld Halting](https://adventofcode.com/2020/day/8)  [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day8.kt)
- Day 9: [Encoding Error](https://adventofcode.com/2020/day/9) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day9.kt)
- Day 10: [Adapter Array](https://adventofcode.com/2020/day/10) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day10.kt)
- Day 11: [Seating System](https://adventofcode.com/2020/day/11) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day11.kt)
- Day 12: [Rain Risk](https://adventofcode.com/2020/day/12) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day12.kt)
- Day 13: [Shuttle Search](https://adventofcode.com/2020/day/13) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day13.kt)
- Day 14: [Docking Data](https://adventofcode.com/2020/day/14) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day14.kt)
- Day 15: [Rambunctious Recitation](https://adventofcode.com/2020/day/15) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day15.kt)
- Day 16: [Ticket Translation](https://adventofcode.com/2020/day/16) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day16.kt)
- Day 17: [Conway Cubes](https://adventofcode.com/2020/day/17) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day17.kt)
- Day 18: [Operation Order](https://adventofcode.com/2020/day/18) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day18.kt)
- Day 19: [Monster Messages](https://adventofcode.com/2020/day/19) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day19.kt)
- Day 20: [Jurassic Jigsaw](https://adventofcode.com/2020/day/20) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day20.kt)
- Day 21: [Allergen Assessment](https://adventofcode.com/2020/day/21) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day21.kt)
- Day 22: [Crab Combat](https://adventofcode.com/2020/day/22) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day22.kt)
- Day 23: [Crab Cups](https://adventofcode.com/2020/day/23) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day23.kt)
- Day 24: [Lobby Layout](https://adventofcode.com/2020/day/24) [🤩](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day24.kt)
- Day 25: [Combo Breaker](https://adventofcode.com/2020/day/25) [🙌](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day25.kt)

### Template

* Based on [aoc-kotlin-starter](https://github.com/hughjdavey/aoc-kotlin-starter) template
  by [Hugh Davey](https://github.com/hughjdavey).

### Features

* Gradle setup so you can run a specific day or all days on the command line (see **Running**)
* Timings for each part of each day
* Input for each day automatically exposed in String and List form
* Junit 5 and AssertJ test libraries included (see **Testing**)
* Starter .gitignore

### Running

Project is already setup with gradle. To run the app:

* Navigate to top-level directory on the command line
* Run `./gradlew run` to run all days
* Run `./gradlew run --args $DAY` where `$DAY` is an integer to run a specific day
* Run `./gradlew run --args "$DAY1 $DAY2 $ANOTHERDAY"` to run a subset of days

### Testing

Project includes Junit and Hamcrest and a stub unit test to get you going. To run all tests:

* Navigate to top-level directory on the command line
* Run `./gradlew test`
* Add `--info`, `--debug` or `--stacktrace` flags for more output

By default, instantiations of `Day` classes in tests will use the input files in `src/test/resources`, _not_ those
in `src/main/resources`. This hopefully gives you flexibility - you could either just copy the real input
into `src/test/resources` if you want to test the actual answers, or you could add a file of test data based on the
examples given on the Advent of Code description for the day. The stub `Day1Test` class shows a test of the
functionality of `Day1` where the test input differs from the actual input.

### Architecture

* Inputs go into `src/main/resources` and follow the naming convention `input_day_X.txt`
* Solutions go into `src/main/kotlin/days` and implement the `Puzzle` interface
* Solutions follow the naming convention `DayX`
* It is assumed all solutions will have two parts
* It is assumed that the puzzle input is provided through the primary constructor
* You can use the `InputReader` methods for reading input
* ~~To get started simply replace `src/main/input_day_1.txt` with the real input and the solutions in `Day1` with your own~~