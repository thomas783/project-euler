# Problem 6: Sum Square Difference

> Source: <https://projecteuler.net/problem=6>

The sum of the squares of the first ten natural numbers is,

$$1^2 + 2^2 + ... + 10^2 = 385.$$

The square of the sum of the first ten natural numbers is,

$$(1 + 2 + ... + 10)^2 = 55^2 = 3025.$$

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is $3025 - 385 = 2640$.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

## Solution

[Problem006.kt](Problem006.kt) · [Problem006Test.kt](../../../../test/kotlin/euler/p006/Problem006Test.kt)

### Approach

Both values have closed forms, so the answer is computed in $O(1)$ without looping.

**1. Square of the sum**

The sum of $1$ to $n$ is the arithmetic series also used in Problem 1:

$$1 + 2 + \dots + n = \frac{n(n + 1)}{2}$$

**2. Sum of the squares**

$$1^2 + 2^2 + \dots + n^2 = \frac{n(n + 1)(2n + 1)}{6}$$

Both formulas always give an integer, so integer division is exact.

**3. Overflow**

The square of the sum grows fastest, roughly as $n^4 / 4$, and exceeds a `Long` from $n = 77{,}936$.
The square uses `Math.multiplyExact`, so an input that is too large fails with an exception instead of returning a wrong number.

**Check with the example** ($n = 10$): $\left(\frac{10 \cdot 11}{2}\right)^2 - \frac{10 \cdot 11 \cdot 21}{6} = 3025 - 385 = 2640$.
