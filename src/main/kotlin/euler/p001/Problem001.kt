package euler.p001

import euler.parseArgs

const val DEFAULT_LIMIT = 1000
const val DEFAULT_FIRST = 3
const val DEFAULT_SECOND = 5

/**
 * Returns the sum of all natural numbers below [limit] that are multiples of [first] or [second] (3 or 5 by default).
 */
fun problem001(limit: Int = DEFAULT_LIMIT, first: Int = DEFAULT_FIRST, second: Int = DEFAULT_SECOND): Long {
  return (getSumOfMultiplesOf(first, limit) + getSumOfMultiplesOf(second, limit) - getSumOfMultiplesOf(
    lcm(first, second),
    limit
  )).toLong()
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

fun lcm(a: Int, b: Int): Int = a / gcd(a, b) * b

fun getSumOfMultiplesOf(k: Int, limit: Int): Int {
  val lastMultipleOf = (limit - 1) / k
  return k * (lastMultipleOf * (lastMultipleOf + 1)) / 2
}

/**
 * Usage: ./gradlew solve -Pproblem=1 --args="limit=1000 first=3 second=5" (every argument is optional)
 */
fun main(args: Array<String>) {
  val options = parseArgs(args, "limit", "first", "second")
  println(
    problem001(
      limit = options["limit"] ?: DEFAULT_LIMIT,
      first = options["first"] ?: DEFAULT_FIRST,
      second = options["second"] ?: DEFAULT_SECOND,
    )
  )
}
