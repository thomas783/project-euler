# Problem 14: Longest Collatz Sequence

> Source: <https://projecteuler.net/problem=14>

The following iterative sequence is defined for the set of positive integers:

- $n \to n/2$ ($n$ is even)
- $n \to 3n + 1$ ($n$ is odd)

Using the rule above and starting with $13$, we generate the following sequence:

$$13 \to 40 \to 20 \to 10 \to 5 \to 16 \to 8 \to 4 \to 2 \to 1.$$

It can be seen that this sequence (starting at $13$ and finishing at $1$) contains $10$ terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at $1$.

Which starting number, under one million, produces the longest chain?

**NOTE:** Once the chain starts the terms are allowed to go above one million.

## Solution

[Problem014.kt](Problem014.kt) · [Problem014Test.kt](../../../../test/kotlin/euler/p014/Problem014Test.kt)

### Approach

Count the length of the chain from every starting number below the limit, and keep the starting number with the longest one.

**1. Chain length**

Apply the rule until the value reaches $1$, counting every term including the starting number and the final $1$.
The count therefore starts at $1$ for the starting number itself.

**2. Keeping the starting number**

The answer is the starting number, not the length, so both the longest length so far and the number that produced it are kept.
Only a strictly longer chain replaces them, so on a tie the smaller starting number stays.

**3. Overflow**

Odd terms are multiplied by $3$, so terms grow well above the starting number.
For starting numbers below one million, the largest term reached is $56{,}991{,}483{,}520$, beyond an `Int` (about $2.1 \times 10^9$), so terms are kept in a `Long`.

**4. Cost**

Each chain is recomputed from scratch, which repeats work (the chain from $13$ passes through $40$, whose chain was already counted).
Caching lengths would avoid that, but the plain loop already finishes in under a second for one million starting numbers.

**Check with the example** (starting at $13$): $13 \to 40 \to 20 \to 10 \to 5 \to 16 \to 8 \to 4 \to 2 \to 1$ has $10$ terms.
