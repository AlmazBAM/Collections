package calculator

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class CalculatorTest {


    @ParameterizedTest
    @MethodSource("calculators")
    fun `sum 10 and 5 result 15`(calculator: Calculator) {
        val result = calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculators")
    fun `sum 100 and 50 result 150`(calculator: Calculator) {
        val result = calculator.sum(100, 50)
        val expected = 150
        assertEquals(expected, result)
    }


    @ParameterizedTest
    @MethodSource("calculators")
    fun `subtract 10 and 5 result 5`(calculator: Calculator) {
        val result = calculator.subtract(10, 5)
        val expected = 5
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculators")
    fun `subtract 100 and 50 result 50`(calculator: Calculator) {
        val result = calculator.subtract(100, 50)
        val expected = 50
        assertEquals(expected, result)
    }


    @ParameterizedTest
    @MethodSource("calculators")
    fun `multiply 10 and 5 result 50`(calculator: Calculator) {
        val result = calculator.multiply(10, 5)
        val expected = 50
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculators")
    fun `multiply 100 and 50 result 5000`(calculator: Calculator) {
        val result = calculator.multiply(100, 50)
        val expected = 5000
        assertEquals(expected, result)
    }


    @ParameterizedTest
    @MethodSource("calculators")
    fun `divide 10 and 5 result 2`(calculator: Calculator) {
        val result = calculator.divide(10, 5)
        val expected = 2.0
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculators")
    fun `divide 100 and 50 result 2`(calculator: Calculator) {
        val result = calculator.divide(100, 50)
        val expected = 2.0
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculators")
    fun `sum 0,1 with itself 100 times result 1,0`(calculator: Calculator) {
        var number = 0.0
        repeat(100) {
            number += 0.01
        }
        assertEquals(1.0, number, 0.00001)
    }

    companion object {
        @JvmStatic
        fun calculators() = listOf(SimpleCalculator(), LoggingCalculator())
    }
}