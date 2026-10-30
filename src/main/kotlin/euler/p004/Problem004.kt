package euler.p004

import euler.parseArgs

const val DEFAULT_DIGITS = 3

/**
 * Returns the largest palindrome made from the product of two [digits]-digit numbers.
 */
fun problem004(digits: Int = DEFAULT_DIGITS): Long {
    // The product of two 9-digit numbers still fits in a Long; 10 digits would not
    require(digits in 1..9) { "digits must be between 1 and 9, but was $digits" }
    var max = 1L
    repeat(digits) { max *= 10 }
    max -= 1
    val min = (max + 1) / 10

    var best = 0L
    var a = max
    while (a >= min && a * max > best) {
        var b = max
        while (b >= a) {
            val product = a * b
            if (product <= best) break
            if (isPalindrome(product)) {
                best = product
                break
            }
            b--
        }
        a--
    }
    return best
}

fun isPalindrome(number: Long): Boolean {
    val text = number.toString()
    return text == text.reversed()
}

/**
 * Usage: ./gradlew solve -Pproblem=4 --args="digits=3" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "digits")
    println(problem004(digits = options["digits"] ?: DEFAULT_DIGITS))
}
