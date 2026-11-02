package euler.p008

import euler.parseArgs

const val DEFAULT_ADJACENT = 13

// The 1000-digit number from the problem statement, split into lines of 50 digits
val NUMBER = """
    73167176531330624919225119674426574742355349194934
    96983520312774506326239578318016984801869478851843
    85861560789112949495459501737958331952853208805511
    12540698747158523863050715693290963295227443043557
    66896648950445244523161731856403098711121722383113
    62229893423380308135336276614282806444486645238749
    30358907296290491560440772390713810515859307960866
    70172427121883998797908792274921901699720888093776
    65727333001053367881220235421809751254540594752243
    52584907711670556013604839586446706324415722155397
    53697817977846174064955149290862569321978468622482
    83972241375657056057490261407972968652414535100474
    82166370484403199890008895243450658541227588666881
    16427171479924442928230863465674813919123162824586
    17866458359124566529476545682848912883142607690042
    24219022671055626321111109370544217506941658960408
    07198403850962455444362981230987879927244284909188
    84580156166097919133875499200524063689912560717606
    05886116467109405077541002256983155200055935729725
    71636269561882670428252483600823257530420752963450
""".filter { it.isDigit() }

/**
 * Returns the greatest product of [adjacent] adjacent digits in [digits].
 */
fun problem008(adjacent: Int = DEFAULT_ADJACENT, digits: String = NUMBER): Long {
    // 9^19 still fits in a Long; 9^20 would not
    require(adjacent in 1..19) { "adjacent must be between 1 and 19, but was $adjacent" }
    require(adjacent <= digits.length) { "adjacent must not exceed the ${digits.length} digits, but was $adjacent" }
    require(digits.all { it.isDigit() }) { "digits must contain only digits" }

    var best = 0L
    for (start in 0..digits.length - adjacent) {
        var product = 1L
        for (i in start until start + adjacent) {
            product *= digits[i] - '0'
        }
        best = maxOf(best, product)
    }
    return best
}

/**
 * Usage: ./gradlew solve -Pproblem=8 --args="adjacent=13" (every argument is optional)
 */
fun main(args: Array<String>) {
    val options = parseArgs(args, "adjacent")
    println(problem008(adjacent = options["adjacent"] ?: DEFAULT_ADJACENT))
}
