package euler.p009

import euler.parseArgs

const val DEFAULT_SUM = 1000

/**
 * Returns the product abc of the Pythagorean triplet a < b < c with a + b + c = [sum].
 */
fun problem009(sum: Int = DEFAULT_SUM): Long {
    require(sum >= 1) { "sum must be at least 1, but was $sum" }
    // a is the smallest of the three, so a < sum / 3
    val limitA = sum / 3
    for (a in 1 until limitA) {
        // b < c = sum - a - b, so b < (sum - a) / 2
        val limitB = (sum - a) / 2
        for (b in (a + 1)..limitB) {
            val c = sum - a - b
            if (a * a + b * b == c * c) {
                return a.toLong() * b * c
            }
        }
    }
    throw IllegalArgumentException("No Pythagorean triplet has the sum $sum")
}

/**
 * Usage: ./gradlew solve -Pproblem=9 --args="sum=1000" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "sum")
    println(problem009(sum = options["sum"] ?: DEFAULT_SUM))
}
