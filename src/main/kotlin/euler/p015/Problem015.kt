package euler.p015

import euler.parseArgs

const val DEFAULT_SIZE = 20

/**
 * Returns the number of routes from the top left to the bottom right corner of a [size] x [size] grid,
 * moving only right and down.
 */
fun problem015(size: Int = DEFAULT_SIZE): Long {
  require(size >= 1) { "size must be at least 1, but was $size" }
  // Routes run along the lines, so a size x size grid has (size + 1) x (size + 1) points
  val grid = Array(size + 1) { LongArray(size + 1) }
  (0..size).forEach {
    grid[0][it] = 1
    grid[it][0] = 1
  }
  (1..size).forEach { y ->
    (1..size).forEach { x ->
      // Fails instead of silently overflowing once the count no longer fits in a Long
      grid[y][x] = Math.addExact(grid[y][x - 1], grid[y - 1][x])
    }
  }
  return grid[size][size]
}

/**
 * Usage: ./gradlew solve -Pproblem=15 --args="size=20" (every argument is optional)
 */
fun main(args: Array<String>) {
  val options = parseArgs(args, "size")
  println(problem015(size = options["size"] ?: DEFAULT_SIZE))
}
