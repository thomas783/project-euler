# Problem 7: 10 001st Prime

> Source: <https://projecteuler.net/problem=7>

By listing the first six prime numbers: $2, 3, 5, 7, 11$, and $13$, we can see that the $6$th prime is $13$.

What is the $10\,001$st prime number?

## Solution

[Problem007.kt](Problem007.kt) · [Problem007Test.kt](../../../../test/kotlin/euler/p007/Problem007Test.kt)

### Approach

Sieve of Eratosthenes up to a known upper bound of the $n$th prime, then count the primes in order.

**1. Upper bound**

A sieve needs its range in advance. For $n \ge 6$, the $n$th prime $p_n$ satisfies

$$p_n < n(\ln n + \ln \ln n)$$

For $n < 6$ the bound $11$ (the 5th prime) is used instead. For $n = 10\,001$ this gives an array of about $114{,}000$ entries.

**2. Sieve**

For each prime $p$ with $p^2 \le \text{limit}$, mark $p^2, p^2 + p, p^2 + 2p, \dots$ as composite.
Marking starts at $p^2$ because every smaller multiple of $p$ has a smaller prime factor and is already marked.
The work is $O(N \log \log N)$ for a range of size $N$, compared with roughly $O(N \sqrt{N})$ for testing each number by trial division.

**3. Count**

Walk the array from $2$ upward and return the number at which the count of unmarked entries reaches $n$.

**Check with the example** ($n = 6$): the bound is $\lfloor 6(\ln 6 + \ln \ln 6) \rfloor + 1 = 15$, and the unmarked numbers up to it are $2, 3, 5, 7, 11, 13$, so the 6th prime is $13$.
