package euler.p017

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem017Test {
    @Test
    fun example() {
        // one, two, three, four, five
        assertEquals(19, problem017(5))
    }

    @Test
    fun noteExamples() {
        // three hundred and forty-two
        assertEquals(23, letterCount(342))
        // one hundred and fifteen
        assertEquals(20, letterCount(115))
    }
}
