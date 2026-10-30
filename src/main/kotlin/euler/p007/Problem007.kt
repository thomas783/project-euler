package euler.p007

import euler.parseArgs
import kotlin.math.ln

const val DEFAULT_NTH = 10_001

/**
 * Returns the [nth] prime number (the 1st prime is 2).
 */
fun problem007(nth: Int = DEFAULT_NTH): Long {
    require(nth >= 1) { "nth must be at least 1, but was $nth" }
    val limit = upperBoundOfNthPrime(nth)
    require(limit < Int.MAX_VALUE) { "nth is too large to sieve: $nth" }
    val isComposite = sieve(limit.toInt())

    var count = 0
    for (number in 2..limit.toInt()) {
        if (!isComposite[number]) {
            count++
            if (count == nth) return number.toLong()
        }
    }
    error("The upper bound $limit was too small for the ${nth}th prime")
}

/**
 * An upper bound of the [n]th prime: n(ln n + ln ln n) holds for n >= 6, and the 5th prime is 11.
 */
fun upperBoundOfNthPrime(n: Int): Long =
    if (n < 6) 11 else (n * (ln(n.toDouble()) + ln(ln(n.toDouble())))).toLong() + 1

/**
 * Sieve of Eratosthenes: `isComposite[k]` is false exactly when k (>= 2) is prime.
 */
fun sieve(limit: Int): BooleanArray {
    val isComposite = BooleanArray(limit + 1)
    var prime = 2
    while (prime.toLong() * prime <= limit) {
        if (!isComposite[prime]) {
            for (multiple in prime * prime..limit step prime) {
                isComposite[multiple] = true
            }
        }
        prime++
    }
    return isComposite
}

/**
 * Usage: ./gradlew solve -Pproblem=7 --args="nth=10001" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "nth")
    println(problem007(nth = options["nth"] ?: DEFAULT_NTH))
}
