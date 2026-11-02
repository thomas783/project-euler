# Problem 10: Summation of Primes

> Source: <https://projecteuler.net/problem=10>

The sum of the primes below $10$ is $2 + 3 + 5 + 7 = 17$.

Find the sum of all the primes below two million.

## Solution

[Problem010.kt](Problem010.kt) · [Problem010Test.kt](../../../../test/kotlin/euler/p010/Problem010Test.kt)

### Approach

Sieve of Eratosthenes over the whole range, then add up the numbers left unmarked.

**1. Sieve**

For each prime $p$ with $p^2 \le \text{limit}$, mark $p^2, p^2 + p, p^2 + 2p, \dots$ as composite, the same sieve as in Problem 7.
For a range of size $N$ this takes $O(N \log \log N)$, which handles two million quickly, whereas trial division would test every number up to its square root.

**2. "Below"**

The primes must be strictly below the limit, so the sieve runs up to $\text{limit} - 1$ and the sum covers $2$ to $\text{limit} - 1$.

**3. Overflow**

The sum of the primes below two million is far larger than an `Int` can hold (about $2.1 \times 10^9$), so it is accumulated in a `Long`.

**Check with the example** (limit $= 10$): the unmarked numbers below $10$ are $2, 3, 5, 7$, and $2 + 3 + 5 + 7 = 17$.
