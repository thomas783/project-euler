package euler.p005

import euler.parseArgs

const val DEFAULT_LIMIT = 20

/**
 * Returns the smallest positive number that is evenly divisible by all of the numbers from 1 to [limit].
 */
fun problem005(limit: Int = DEFAULT_LIMIT): Long {
    require(limit >= 1) { "limit must be at least 1, but was $limit" }
    var answer = 1L
    for (number in 2..limit) {
        answer = lcm(answer, number.toLong())
    }
    return answer
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)

// Fails instead of silently overflowing once the result no longer fits in a Long
fun lcm(a: Long, b: Long): Long = Math.multiplyExact(a / gcd(a, b), b)

/**
 * Usage: ./gradlew solve -Pproblem=5 --args="limit=20" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "limit")
    println(problem005(limit = options["limit"] ?: DEFAULT_LIMIT))
}
