package euler.p016

import euler.parseArgs

const val DEFAULT_EXPONENT = 1000

/**
 * Returns the sum of the digits of 2^[exponent].
 */
fun problem016(exponent: Int = DEFAULT_EXPONENT): Int {
    require(exponent >= 0) { "exponent must be at least 0, but was $exponent" }
    // Digits of the power, least significant first, so a new leading digit is just appended
    val digits = mutableListOf(1)
    repeat(exponent) {
        var carry = 0
        for (i in digits.indices) {
            val value = digits[i] * 2 + carry
            digits[i] = value % 10
            carry = value / 10
        }
        if (carry > 0) digits.add(carry)
    }
    return digits.sum()
}

/**
 * Usage: ./gradlew solve -Pproblem=16 --args="exponent=1000" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "exponent")
    println(problem016(exponent = options["exponent"] ?: DEFAULT_EXPONENT))
}
