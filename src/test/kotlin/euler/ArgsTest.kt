package euler

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ArgsTest {
    @Test
    fun parsesGivenKeysOnly() {
        assertEquals(mapOf("second" to 7), parseArgs(arrayOf("second=7"), "limit", "first", "second"))
    }

    @Test
    fun emptyArgsGiveEmptyMap() {
        assertEquals(emptyMap(), parseArgs(emptyArray(), "limit"))
    }

    @Test
    fun rejectsUnknownKey() {
        assertFailsWith<IllegalArgumentException> { parseArgs(arrayOf("limt=10"), "limit") }
    }

    @Test
    fun rejectsMissingValue() {
        assertFailsWith<IllegalArgumentException> { parseArgs(arrayOf("limit"), "limit") }
    }

    @Test
    fun rejectsNonInteger() {
        assertFailsWith<IllegalArgumentException> { parseArgs(arrayOf("limit=abc"), "limit") }
    }

    @Test
    fun rejectsDuplicateKey() {
        assertFailsWith<IllegalArgumentException> { parseArgs(arrayOf("limit=1", "limit=2"), "limit") }
    }
}
