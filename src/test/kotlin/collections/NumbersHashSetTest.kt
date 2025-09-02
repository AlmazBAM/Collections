package collections

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test


class NumbersHashSetTest {

    private val elements = NumbersHashSet()

    @Test
    fun `When add 100 elements then size 100`() {
        repeat(100) {
            elements.add(it)
        }
        assertEquals(100, elements.size)
    }

    @Test
    fun `When add 10 similar elements then size 1`() {
        repeat(100) {
            elements.add(0)
        }
        assertEquals(1, elements.size)
    }

    @Test
    fun `When add non similar element then return true`() {
        assertTrue(elements.add(100))
    }

    @Test
    fun `When add similar element then return false`() {
        elements.add(10)
        assertFalse(elements.add(10))
    }

    @Test
    fun `When present in set then return true`() {
        elements.add(10)
        assertTrue(elements.contains(10))
    }

    @Test
    fun `When not present in set then return false`() {
        repeat(10) { elements.add(it) }
        assertFalse(elements.contains(11))
    }

    @Test
    fun `When remove element from set then decrease size`() {
        repeat(10) { elements.add(it) }
        elements.remove(2)
        assertEquals(9, elements.size)
    }

    @Test
    fun `When remove element from set then contains return false`() {
        repeat(10) { elements.add(it) }
        elements.remove(2)
        assertFalse { elements.contains(2) }
    }

    @Test
    fun `When set is cleared then size 0`() {
        repeat(10) { elements.add(it) }
        elements.clear()
        assertEquals(0, elements.size)
    }

    @Test
    fun `When set is cleared then contains return false`() {
        repeat(10) { elements.add(it) }
        elements.clear()
        repeat(10) {
            assertFalse { elements.contains(it) }
        }
    }
}