package collections

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NumbersArrayListTest {


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list contains element then return true`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        assertTrue(list.contains(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list doesn't contains element then return false`(list: NumbersArrayList) {
        repeat(10) {
            list.add(it)
        }
        assertFalse { list.contains(1000) }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 10 items then size is 10`(list: NumbersArrayList) {
        repeat(10) {
            list.add(it)
        }
        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 item into list then size should return 1`(list: NumbersArrayList) {
        repeat(1) {
            list.add(it)
        }
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 100 items then size is 100`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add value 1000 in the beginning then 1st element is 1000`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.add(0, 1000)
        assertEquals(1000, list.get(0))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add value 1000 in the end then size is increased`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.add(100, 1000)
        assertEquals(101, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add value 1000 in the end then last element is 1000`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.add(100, 1000)
        assertEquals(1000, list.get(100))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When 50th element removed then size decreased`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(51, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When value 50 removed then size decreased`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.remove(50)
        assertEquals(51, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When 50th element removed then next value at this position`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(51, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When clear list then size is 0`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When clear list and get 50th element then throw exception`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        list.clear()
        assertThrows<IndexOutOfBoundsException> {
            list.get(50)
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get number 50th element then result is correct`(list: NumbersArrayList) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(50, list.get(50))
    }

    companion object {
        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList())
    }
}