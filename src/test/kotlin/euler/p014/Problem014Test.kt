package euler.p014

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem014Test {
    @Test
    fun example() {
        // 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
        assertEquals(10, chainLength(13))
    }
}
