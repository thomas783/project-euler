package euler.p010

import euler.parseArgs

const val DEFAULT_LIMIT = 2_000_000

/**
 * Returns the sum of all the primes below [limit].
 */
fun problem010(limit: Int = DEFAULT_LIMIT): Long {
    require(limit >= 1) { "limit must be at least 1, but was $limit" }
    // "Below" excludes the limit itself
    val isComposite = sieve(limit - 1)
    var sum = 0L
    for (number in 2 until limit) {
        if (!isComposite[number]) sum += number
    }
    return sum
}

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
 * Usage: ./gradlew solve -Pproblem=10 --args="limit=2000000" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "limit")
    println(problem010(limit = options["limit"] ?: DEFAULT_LIMIT))
}
