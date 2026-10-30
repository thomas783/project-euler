# Problem 4: Largest Palindrome Product

> Source: <https://projecteuler.net/problem=4>

A palindromic number reads the same both ways. The largest palindrome made from the product of two $2$-digit numbers is $9009 = 91 \times 99$.

Find the largest palindrome made from the product of two $3$-digit numbers.

## Solution

[Problem004.kt](Problem004.kt) · [Problem004Test.kt](../../../../test/kotlin/euler/p004/Problem004Test.kt)

### Approach

Search the products from the largest factors downward, and prune every product that can no longer beat the best palindrome found so far.

**1. Search order**

For $n$-digit numbers, both factors $a$ and $b$ run from $10^n - 1$ down to $10^{n-1}$.
Since $a \times b = b \times a$, only pairs with $b \ge a$ are checked.

**2. Pruning**

Let $\text{best}$ be the largest palindrome found so far.

- Inner loop: once $a \times b \le \text{best}$, smaller $b$ only gives smaller products, so stop and move to the next $a$.
- Inner loop: the first palindrome found for an $a$ is the largest one for that $a$, because $b$ is decreasing, so stop there too.
- Outer loop: once even $a \times (10^n - 1) \le \text{best}$, no remaining $a$ can do better, so the search ends.

For 3-digit numbers this checks about $3{,}200$ products instead of all $405{,}450$ pairs.

**3. Palindrome check**

Convert the number to a string and compare it with its reverse.

**Check with the example** ($n = 2$): $91 \times 99 = 9009$ is the largest palindrome from two 2-digit numbers.
