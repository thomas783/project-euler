# Problem 16: Power Digit Sum

> Source: <https://projecteuler.net/problem=16>

$2^{15} = 32768$ and the sum of its digits is $3 + 2 + 7 + 6 + 8 = 26$.

What is the sum of the digits of the number $2^{1000}$?

## Solution

[Problem016.kt](Problem016.kt) · [Problem016Test.kt](../../../../test/kotlin/euler/p016/Problem016Test.kt)

### Approach

Build $2^n$ digit by digit by doubling $n$ times, without a big-integer type, then add up the digits.

**1. Digits, least significant first**

$2^{1000}$ has $\lfloor 1000 \log_{10} 2 \rfloor + 1 = 302$ digits, far beyond a `Long` (at most 19 digits), so the number is kept as a list of digits.
The ones digit comes first, so when the number grows by a digit, the new leading digit is simply appended to the end.

**2. Doubling**

Starting from $1$, each step doubles every digit from the ones digit upward, adding the carry from the digit before:
the last digit of that value ($\bmod 10$) stays, and the rest ($\div 10$) is carried.
A digit is at most $9 \times 2 + 1 = 19$, so the carry is always $0$ or $1$.
A carry left over after the leading digit becomes a new leading digit.

**3. Cost**

There are $n$ doublings over at most about $0.3n$ digits, so fewer than $0.3n^2$ digit operations, under $300{,}000$ for $n = 1000$.

**Check with the example** ($n = 15$): doubling $1$ fifteen times gives $32768$, and $3 + 2 + 7 + 6 + 8 = 26$.
