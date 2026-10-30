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

## Run

```bash
./gradlew solve -Pproblem=1 --args="1000"          # run a solution with your own input
./gradlew test                                     # all problems
./gradlew test --tests 'euler.p001.Problem001Test' # one problem
```

## Progress

| # | Problem | Solution |
|---|---------|----------|
| 1 | [Multiples of 3 or 5](src/main/kotlin/euler/p001) | [Problem001.kt](src/main/kotlin/euler/p001/Problem001.kt) |

## License

Problem statements are from [Project Euler](https://projecteuler.net/) and are licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
