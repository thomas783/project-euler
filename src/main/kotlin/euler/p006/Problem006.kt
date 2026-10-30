package euler.p006

import euler.parseArgs

const val DEFAULT_LIMIT = 100

/**
 * Returns the difference between the square of the sum and the sum of the squares of the first [limit] natural numbers.
 */
fun problem006(limit: Int = DEFAULT_LIMIT): Long {
    require(limit >= 1) { "limit must be at least 1, but was $limit" }
    val n = limit.toLong()
    val sum = n * (n + 1) / 2
    // Fails instead of silently overflowing once the result no longer fits in a Long
    val squareOfSum = Math.multiplyExact(sum, sum)
    val sumOfSquares = n * (n + 1) * (2 * n + 1) / 6
    return squareOfSum - sumOfSquares
}

/**
 * Usage: ./gradlew solve -Pproblem=6 --args="limit=100" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "limit")
    println(problem006(limit = options["limit"] ?: DEFAULT_LIMIT))
}
