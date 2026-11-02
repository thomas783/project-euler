package euler.p009

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem009Test {
    @Test
    fun example() {
        // 3 + 4 + 5 = 12 and 3 * 4 * 5 = 60
        assertEquals(60L, problem009(12))
    }
}
