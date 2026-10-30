package euler.p002

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem002Test {
    @Test
    fun example() {
        // Even terms among the first 10 terms listed in the statement: 2 + 8 + 34
        assertEquals(44L, problem002(89))
    }
}
