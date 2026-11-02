package euler.p016

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem016Test {
    @Test
    fun example() {
        // 2^15 = 32768 and 3 + 2 + 7 + 6 + 8 = 26
        assertEquals(26, problem016(15))
    }
}
