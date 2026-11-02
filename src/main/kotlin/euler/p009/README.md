# Problem 9: Special Pythagorean Triplet

> Source: <https://projecteuler.net/problem=9>

A Pythagorean triplet is a set of three natural numbers, $a \lt b \lt c$, for which,

$$a^2 + b^2 = c^2.$$

For example, $3^2 + 4^2 = 9 + 16 = 25 = 5^2$.

There exists exactly one Pythagorean triplet for which $a + b + c = 1000$.
Find the product $abc$.

## Solution

[Problem009.kt](Problem009.kt) · [Problem009Test.kt](../../../../test/kotlin/euler/p009/Problem009Test.kt)

### Approach

Fix $a$ and $b$, derive $c = s - a - b$ from the sum $s$, and check $a^2 + b^2 = c^2$.

**1. Range of $a$**

$a$ is the smallest of the three, so $3a < a + b + c = s$, that is $a < s / 3$.

**2. Range of $b$**

$b$ starts at $a + 1$, and $b < c = s - a - b$ gives $b < (s - a) / 2$.
The loop goes up to $\lfloor (s - a) / 2 \rfloor$ inclusive: when $s - a$ is even the last value makes $b = c$, which can never satisfy $a^2 + b^2 = c^2$, so it is harmless.

Because both ranges already enforce $a < b < c$, the order never needs a separate check.
For $s = 1000$ this tries at most $83{,}000$ pairs.

**3. Result**

The first triplet found is returned as the `Long` product $abc$.
If no triplet has the sum $s$ (for example $s = 7$), an `IllegalArgumentException` is thrown; if several do (for example $s = 120$), the one with the smallest $a$ is returned.

**Check with the example** ($s = 12$): $a = 3$, $b = 4$, $c = 5$ satisfies $9 + 16 = 25$, and $3 \cdot 4 \cdot 5 = 60$.
