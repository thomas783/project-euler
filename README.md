# Project Euler

Solutions to [Project Euler](https://projecteuler.net/) problems in Kotlin.

Following the site's rules, only solutions to the first 100 problems are published here.

## Structure

Each problem has its own package, `euler.pNNN`:

```
src/main/kotlin/euler/p001/
├── README.md          # problem statement
└── Problem001.kt      # solution
src/test/kotlin/euler/p001/
└── Problem001Test.kt  # checks the example from the statement
```

`src/main/kotlin/euler/Args.kt` parses the `key=value` arguments passed to `solve`.

## Run

```bash
./gradlew solve -Pproblem=1                        # run a solution with the default input
./gradlew solve -Pproblem=1 --args="second=7"      # override some of the inputs by name
./gradlew test                                     # all problems
./gradlew test --tests 'euler.p001.Problem001Test' # one problem
```

## Progress

| # | Problem | Solution |
|---|---------|----------|
| 1 | [Multiples of 3 or 5](src/main/kotlin/euler/p001) | [Problem001.kt](src/main/kotlin/euler/p001/Problem001.kt) |
| 2 | [Even Fibonacci Numbers](src/main/kotlin/euler/p002) | [Problem002.kt](src/main/kotlin/euler/p002/Problem002.kt) |
| 3 | [Largest Prime Factor](src/main/kotlin/euler/p003) | [Problem003.kt](src/main/kotlin/euler/p003/Problem003.kt) |
| 4 | [Largest Palindrome Product](src/main/kotlin/euler/p004) | [Problem004.kt](src/main/kotlin/euler/p004/Problem004.kt) |
| 5 | [Smallest Multiple](src/main/kotlin/euler/p005) | [Problem005.kt](src/main/kotlin/euler/p005/Problem005.kt) |

## License

Problem statements are from [Project Euler](https://projecteuler.net/) and are licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
