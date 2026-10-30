package euler.p001

/**
 * Returns the sum of all natural numbers below [limit] that are multiples of [first] or [second] (3 or 5 by default).
 */
fun problem001(limit: Int = 1000, first: Int = 3, second: Int = 5): Long {
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
 * Usage: ./gradlew solve -Pproblem=1 --args="[limit] [first] [second]", e.g. --args="1000 3 5"
 */
fun main(args: Array<String>) {
  val numbers = args.map { it.toInt() }
  val result = when (numbers.size) {
    0 -> problem001()
    1 -> problem001(numbers[0])
    2 -> problem001(numbers[0], numbers[1])
    else -> problem001(numbers[0], numbers[1], numbers[2])
  }
  println(result)
}
