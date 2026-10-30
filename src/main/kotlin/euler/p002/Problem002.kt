package euler.p002

import euler.parseArgs

const val DEFAULT_LIMIT = 4_000_000

/**
 * Returns the sum of the even-valued Fibonacci terms (starting with 1 and 2) that do not exceed [limit].
 */
fun problem002(limit: Int = DEFAULT_LIMIT): Long {
    var answer = 0L
    var first = 1
    var second = 2
    var index = 2
    while(second <= limit) {
        if (index % 3 == 2) {
            answer += second
        }
        val next = first + second
        first = second
        second = next
        index++
    }
    return answer
}

/**
 * Usage: ./gradlew solve -Pproblem=2 --args="limit=4000000" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "limit")
    println(problem002(limit = options["limit"] ?: DEFAULT_LIMIT))
}
