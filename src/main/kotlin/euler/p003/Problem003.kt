package euler.p003

import euler.parseLongArgs

const val DEFAULT_NUMBER = 600_851_475_143L

/**
 * Returns the largest prime factor of [number].
 */
fun problem003(number: Long = DEFAULT_NUMBER): Long {
    require(number >= 2) { "number must be at least 2, but was $number" }
    var remaining = number
    var largest = 1L
    var factor = 2L
    while (factor * factor <= remaining) {
        while (remaining % factor == 0L) {
            largest = factor
            remaining /= factor
        }
        factor++
    }
    return if (remaining > 1) remaining else largest
}

/**
 * Usage: ./gradlew solve -Pproblem=3 --args="number=600851475143" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseLongArgs(args, "number")
    println(problem003(number = options["number"] ?: DEFAULT_NUMBER))
}
