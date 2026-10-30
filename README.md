# Project Euler

Solutions to [Project Euler](https://projecteuler.net/) problems in Kotlin.

Following the site's rules, only solutions to the first 100 problems are published here.

## Structure

- `src/main/kotlin/euler/ProblemNNN.kt`: solution for problem NNN
- `src/test/kotlin/euler/ProblemNNNTest.kt`: checks the example from the statement and the final answer

## Run

```bash
./gradlew test                                # all problems
./gradlew test --tests 'euler.Problem001Test' # one problem
```

## Progress

| # | Problem | Solution |
|---|---------|----------|
| 1 | [Multiples of 3 or 5](https://projecteuler.net/problem=1) | [Problem001.kt](src/main/kotlin/euler/Problem001.kt) |
