# Problem 3: Largest Prime Factor

> Source: <https://projecteuler.net/problem=3>

The prime factors of $13195$ are $5, 7, 13$ and $29$.

What is the largest prime factor of the number $600851475143$?

## Solution

[Problem003.kt](Problem003.kt) · [Problem003Test.kt](../../../../test/kotlin/euler/p003/Problem003Test.kt)

### Approach

Trial division from the smallest factor, dividing each factor out completely before moving on.

**1. Divide factors out completely**

Try $2, 3, 4, \dots$ in order. Whenever a factor divides the remaining number, divide by it as many times as possible.
Because smaller factors are already removed, every factor that still divides is prime: once all $2$s are gone, $4$ can never divide.

**2. Stop at the square root of what remains**

The loop runs while $\text{factor}^2 \le \text{remaining}$. A composite number always has a factor no larger than its square root, so if no factor up to $\sqrt{\text{remaining}}$ divides it, the remaining number is prime.
Since the remaining number shrinks with every division, the bound shrinks too.

**3. The leftover is the answer, if any**

The largest prime factor can be larger than $\sqrt{n}$ (e.g. $26 = 2 \cdot 13$).
After the loop, a remaining number greater than $1$ is that prime and is the answer. Otherwise the last factor divided out is the answer (e.g. $8 = 2^3$).

**Check with the example** ($n = 13195$): dividing by $5, 7, 13$ leaves $29$. Since $14^2 > 29$, the loop stops and $29$ is the answer.
