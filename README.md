# Advent of Code 2020: Solutions in Kotlin

My attempts at solving the [Advent of Code 2020](https://adventofcode.com/2020) with
the [Kotlin](https://kotlinlang.org/)
programming language.

## Solutions

- Day 1: [Report Repair](https://adventofcode.com/2020/day/1)
  , [Solution](https://github.com/andilau/advent-of-code-2020/blob/main/src/main/kotlin/days/Day1.kt)
- Day 2: [Password Philosophy](https://adventofcode.com/2020/day/2)
- Day 3: [Toboggan Trajectory](https://adventofcode.com/2020/day/3)
- Day 4: [Passport Processing](https://adventofcode.com/2020/day/4)
- Day 5: [Binary Boarding](https://adventofcode.com/2020/day/5)
- Day 6: [Custom Customs](https://adventofcode.com/2020/day/6)
- Day 7: [Handy Haversacks](https://adventofcode.com/2020/day/7)
- Day 8: [Handheld Halting](https://adventofcode.com/2020/day/8)
- Day 9: [Encoding Error](https://adventofcode.com/2020/day/9)
- Day 10: [Adapter Array](https://adventofcode.com/2020/day/10)
- Day 11: [Seating System](https://adventofcode.com/2020/day/11)
- Day 12: [Rain Risk](https://adventofcode.com/2020/day/12)
- Day 13: [Shuttle Search](https://adventofcode.com/2020/day/13)

## Template

Starter template for solving [Advent of Code](https://adventofcode.com) in [Kotlin](https://kotlinlang.org/)

### Features

* Gradle setup so you can run a specific day or all days on the command line (see **Running** below)
* Timings for each part of each day
* Input for each day automatically exposed in String and List form
* Junit and Hamcrest test libraries included (see **Testing** below)
* Starter .gitignore

### Running

Project is already setup with gradle. To run the app:

* Navigate to top-level directory on the command line
* Run `./gradlew run` to run all days
* Run `./gradlew run --args $DAY` where `$DAY` is an integer to run a specific day

### Testing

Project includes Junit and Hamcrest and a stub unit test to get you going. To run all tests:

* Navigate to top-level directory on the command line
* Run `./gradlew test`
* Add `--info`, `--debug` or `--stacktrace` flags for more output

##### Test input

By default, instantiations of `Day` classes in tests will use the input files in `src/test/resources`, _not_ those in `src/main/resources`.
This hopefully gives you flexibility - you could either just copy the real input into `src/test/resources` if you want to test
the actual answers, or you could add a file of test data based on the examples given on the Advent of Code description for the day.
The stub `Day1Test` class shows a test of the functionality of `Day1` where the test input differs from the actual input.

### Architecture

* Inputs go into `src/main/resources` and follow the naming convention `input_day_X.txt`
* Solutions go into `src/main/kotlin/days` and extend the `Day` abstract class, calling its constructor with their day number 
* Solutions follow the naming convention `DayX`
* It is assumed all solutions will have two parts but share the same input
* Input is exposed in the solution classes in two forms - `inputList` and `inputString`
* Day 1 solution class and input file are stubbed as a guide on how to extend the project,
and how you can use the `inputList` and `inputString` mentioned above
* To get started simply replace `src/main/input_day_1.txt` with the real input and the solutions in `Day1` with your own
* A Day 1 test class also exists, mostly to show a few hamcrest matchers, and how test input files can differ from actual ones (see **Test input** section above).
To get started with testing you can edit this class, and the input file at `src/test/resources/input_day_1.txt`
