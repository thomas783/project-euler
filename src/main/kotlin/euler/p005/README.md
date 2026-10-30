# Problem 5: Smallest Multiple

> Source: <https://projecteuler.net/problem=5>

$2520$ is the smallest number that can be divided by each of the numbers from $1$ to $10$ without any remainder.

What is the smallest positive number that is evenly divisible (divisible with no remainder) by all of the numbers from $1$ to $20$?

## Solution

[Problem005.kt](Problem005.kt) · [Problem005Test.kt](../../../../test/kotlin/euler/p005/Problem005Test.kt)

### Approach

The smallest number divisible by every number from $1$ to $n$ is, by definition, the least common multiple of $1, 2, \dots, n$.

**1. Fold the LCM two numbers at a time**

The LCM is associative, $\mathrm{lcm}(a, b, c) = \mathrm{lcm}(\mathrm{lcm}(a, b), c)$, so it can be accumulated one number at a time:

$$1 \to \mathrm{lcm}(1, 2) = 2 \to \mathrm{lcm}(2, 3) = 6 \to \mathrm{lcm}(6, 4) = 12 \to \dots$$

**2. LCM from the GCD**

$$\mathrm{lcm}(a, b) = \frac{a}{\gcd(a, b)} \cdot b$$

The GCD comes from the Euclidean algorithm, $\gcd(a, b) = \gcd(b, a \bmod b)$.
Dividing before multiplying keeps the intermediate value small.

**3. Overflow**

The result grows quickly: the LCM of $1$ to $42$ still fits in a `Long`, but $1$ to $43$ does not.
The multiplication uses `Math.multiplyExact`, so an input that is too large fails with an exception instead of returning a wrong number.

**Check with the example** ($n = 10$): folding the LCM over $1$ to $10$ gives $2520$.
