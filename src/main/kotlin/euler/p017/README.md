# Problem 17: Number Letter Counts

> Source: <https://projecteuler.net/problem=17>

If the numbers $1$ to $5$ are written out in words: one, two, three, four, five, then there are $3 + 3 + 5 + 4 + 4 = 19$ letters used in total.

If all the numbers from $1$ to $1000$ (one thousand) inclusive were written out in words, how many letters would be used?

**NOTE:** Do not count spaces or hyphens. For example, $342$ (three hundred and forty-two) contains $23$ letters and $115$ (one hundred and fifteen) contains $20$ letters. The use of "and" when writing out numbers is in compliance with British usage.

## Solution

[Problem017.kt](Problem017.kt) · [Problem017Test.kt](../../../../test/kotlin/euler/p017/Problem017Test.kt)

### Approach

Write each number out as words, count the letters, and add them up.

**1. Splitting a number**

A number below $1000$ splits into the hundreds digit and the last two digits:

- **Hundreds**: "*digit* hundred", for example "three hundred"
- **"and"**: British usage adds "and" after the hundreds, but only when the last two digits are not zero ($300$ is "three hundred", $342$ is "three hundred and forty-two")
- **Last two digits**:
  - $1$ to $19$ each have their own word ("one" to "nineteen"), since the teens do not follow a pattern
  - $20$ and above are a tens word, plus a hyphen and a ones word unless the ones digit is $0$ ("forty", "forty-two")

$1000$ is the one special case, "one thousand".

**2. Counting letters**

Building the actual words rather than adding up letter counts makes spelling mistakes visible (for example "forty", not "fourty").
Spaces and hyphens are not letters, so counting only letters handles them without extra rules.

**Check with the examples**:

- $1$ to $5$: one, two, three, four, five, $3 + 3 + 5 + 4 + 4 = 19$
- $342$: three hundred and forty-two, $5 + 7 + 3 + 5 + 3 = 23$
- $115$: one hundred and fifteen, $3 + 7 + 3 + 7 = 20$
