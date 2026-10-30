package euler

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem001Test {
    @Test
    fun example() {
        assertEquals(23L, problem001(10))
    }

    @Test
    fun answer() {
        assertEquals(233168L, problem001(1000))
    }
}
