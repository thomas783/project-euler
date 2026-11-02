package euler.p011

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem011Test {
    @Test
    fun example() {
        // The four red numbers run diagonally down-right from row 7, column 9 (1-based)
        val product = (0 until 4).fold(1L) { acc, k -> acc * GRID[6 + k][8 + k] }
        assertEquals(1788696L, product)
    }
}
