package euler.p001

/**
 * Returns the sum of all natural numbers below [limit] that are multiples of 3 or 5.
 */
fun problem001(limit: Int): Long {
    TODO("Not solved yet")
}

/**
 * Usage: ./gradlew solve -Pproblem=1 --args="1000"
 */
fun main(args: Array<String>) {
    val limit = args.firstOrNull()?.toInt() ?: 1000
    println(problem001(limit))
}
