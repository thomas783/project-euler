# Problem 1: Multiples of 3 or 5

> Source: <https://projecteuler.net/problem=1>

If we list all the natural numbers below $10$ that are multiples of $3$ or $5$, we get $3, 5, 6$ and $9$. The sum of these multiples is $23$.

Find the sum of all the multiples of $3$ or $5$ below $1000$.

## Solution

[Problem001.kt](Problem001.kt) · [Problem001Test.kt](../../../../test/kotlin/euler/p001/Problem001Test.kt)

### Approach

Instead of looping over every number below the limit, the answer is computed directly in $O(1)$.

**1. Sum of the multiples of $k$ below $n$**

The multiples of $k$ below $n$ are $k, 2k, \dots, mk$, where $m = \lfloor (n - 1) / k \rfloor$.
Using $n - 1$ instead of $n$ matters: the range is *below* $n$, so $n$ itself must not be counted when it is a multiple of $k$.

Factoring out $k$ leaves the arithmetic series $1 + 2 + \dots + m$:

$$S(k) = k \cdot \frac{m(m + 1)}{2}$$

**2. Inclusion–exclusion**

Adding $S(3)$ and $S(5)$ counts the numbers that are multiples of both twice (15, 30, ...), so they are subtracted once:

$$S(3) + S(5) - S(\mathrm{lcm}(3, 5))$$

For 3 and 5 the overlap is the multiples of 15. The code takes the two divisors as parameters, so it uses $\mathrm{lcm}$ rather than the product: for 2 and 4, the overlap is the multiples of 4, not 8.

**Check with the example** ($n = 10$): $S(3) = 3 \cdot \frac{3 \cdot 4}{2} = 18$, $S(5) = 5 \cdot \frac{1 \cdot 2}{2} = 5$, $S(15) = 0$, so the sum is $23$.
