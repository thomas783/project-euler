package euler.p017

import euler.parseArgs

const val DEFAULT_LIMIT = 1000

// Index i holds the word for i; 1 to 19 each have their own word
private val ONES = listOf(
    "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
)

// Index i holds the word for i * 10, from twenty upward
private val TENS = listOf("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

/**
 * Returns the number of letters used to write out every number from 1 to [limit] inclusive in British English.
 */
fun problem017(limit: Int = DEFAULT_LIMIT): Int {
    require(limit in 1..1000) { "limit must be between 1 and 1000, but was $limit" }
    return (1..limit).sumOf { letterCount(it) }
}

/**
 * Returns the number of letters in [number] written out in British English, without spaces or hyphens.
 */
fun letterCount(number: Int): Int = toWords(number).count { it.isLetter() }

/**
 * Writes [number] (1 to 1000) out in British English, for example 342 as "three hundred and forty-two".
 */
fun toWords(number: Int): String {
    require(number in 1..1000) { "number must be between 1 and 1000, but was $number" }
    if (number == 1000) return "one thousand"

    val hundreds = number / 100
    val rest = number % 100
    val parts = mutableListOf<String>()
    if (hundreds > 0) parts += "${ONES[hundreds]} hundred"
    // British usage puts "and" after the hundreds, but only when something follows
    if (hundreds > 0 && rest > 0) parts += "and"
    if (rest in 1..19) {
        parts += ONES[rest]
    } else if (rest >= 20) {
        parts += if (rest % 10 == 0) TENS[rest / 10] else "${TENS[rest / 10]}-${ONES[rest % 10]}"
    }
    return parts.joinToString(" ")
}

/**
 * Usage: ./gradlew solve -Pproblem=17 --args="limit=1000" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "limit")
    println(problem017(limit = options["limit"] ?: DEFAULT_LIMIT))
}
