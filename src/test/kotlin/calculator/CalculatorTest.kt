package calculator

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `sum 10 and 5 result 15`() {
        val result =  calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @Test
    fun `sum 100 and 50 result 150`() {
        val result =  calculator.sum(100, 50)
        val expected = 150
        assertEquals(expected, result)
    }


    @Test
    fun `subtract 10 and 5 result 5`() {
        val result =  calculator.subtract(10, 5)
        val expected = 5
        assertEquals(expected, result)
    }

    @Test
    fun `subtract 100 and 50 result 50`() {
        val result =  calculator.subtract(100, 50)
        val expected = 50
        assertEquals(expected, result)
    }


    @Test
    fun `multiply 10 and 5 result 50`() {
        val result =  calculator.multiply(10, 5)
        val expected = 50
        assertEquals(expected, result)
    }

    @Test
    fun `multiply 100 and 50 result 5000`() {
        val result =  calculator.multiply(100, 50)
        val expected = 5000
        assertEquals(expected, result)
    }


    @Test
    fun `divide 10 and 5 result 2`() {
        val result =  calculator.divide(10, 5)
        val expected = 2.0
        assertEquals(expected, result)
    }

    @Test
    fun `divide 100 and 50 result 2`() {
        val result =  calculator.divide(100, 50)
        val expected = 2.0
        assertEquals(expected, result)
    }

    @Test
    fun `sum 0,1 with itself 100 times result 1,0`() {
        var number = 0.0
        repeat(100) {
            number += 0.01
        }
        assertEquals(1.0, number, 0.00001)
    }
}