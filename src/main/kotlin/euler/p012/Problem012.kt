package euler.p012

import euler.parseArgs

const val DEFAULT_DIVISORS = 500

/**
 * Returns the first triangle number to have over [divisors] divisors.
 */
fun problem012(divisors: Int = DEFAULT_DIVISORS): Long {
    require(divisors >= 0) { "divisors must be at least 0, but was $divisors" }
    var n = 1L
    while (true) {
        // The nth triangle number is n(n + 1) / 2. n and n + 1 share no factor, so after halving
        // the even one, the divisor count is the product of the two halves' divisor counts.
        val (a, b) = if (n % 2 == 0L) n / 2 to n + 1 else n to (n + 1) / 2
        if (countDivisors(a) * countDivisors(b) > divisors) return a * b
        n++
    }
}

/**
 * Counts the divisors of [number] from its prime factorization: p^a * q^b * ... has (a + 1)(b + 1)... divisors.
 */
fun countDivisors(number: Long): Int {
    var remaining = number
    var count = 1
    var factor = 2L
    while (factor * factor <= remaining) {
        var exponent = 0
        while (remaining % factor == 0L) {
            remaining /= factor
            exponent++
        }
        count *= exponent + 1
        factor++
    }
    // Whatever is left above 1 is a prime factor with exponent 1
    if (remaining > 1) count *= 2
    return count
}

/**
 * Usage: ./gradlew solve -Pproblem=12 --args="divisors=500" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "divisors")
    println(problem012(divisors = options["divisors"] ?: DEFAULT_DIVISORS))
}
