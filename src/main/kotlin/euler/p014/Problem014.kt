package euler.p014

import euler.parseArgs

const val DEFAULT_LIMIT = 1_000_000

/**
 * Returns the starting number below [limit] that produces the longest Collatz chain.
 */
fun problem014(limit: Int = DEFAULT_LIMIT): Long {
    require(limit >= 2) { "limit must be at least 2, but was $limit" }
    // Keep the starting number, not just the length, since the answer is the starting number
    var answer = 0L
    var longest = 0
    (1 until limit).forEach {
        val length = chainLength(it.toLong())
        if (length > longest) {
            longest = length
            answer = it.toLong()
        }
    }
    return answer
}

/**
 * Returns the number of terms in the Collatz chain from [start] down to 1, counting both ends.
 */
fun chainLength(start: Long): Int {
    // 0 would stay 0 forever, and negative numbers never reach 1
    require(start >= 1) { "start must be at least 1, but was $start" }
    var count = 1
    var current = start
    while (current != 1L) {
        if (current % 2 == 0L) {
            current /= 2
        } else {
            current = current * 3 + 1
        }
        count++
    }
    return count
}

/**
 * Usage: ./gradlew solve -Pproblem=14 --args="limit=1000000" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "limit")
    println(problem014(limit = options["limit"] ?: DEFAULT_LIMIT))
}
