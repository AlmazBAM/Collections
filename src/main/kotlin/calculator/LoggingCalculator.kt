package calculator

class LoggingCalculator : Calculator {

    override fun sum(a: Int, b: Int): Int {
        val result = a + b
        println("sum $a + $b = $result")
        return result
    }

    override fun subtract(a: Int, b: Int): Int {
        val result = a - b
        println("subtract $a + $b = $result")
        return result
    }

    override fun multiply(a: Int, b: Int): Int {
        val result = a * b
        println("multiply $a + $b = $result")
        return result
    }

    override fun divide(a: Int, b: Int): Double {
        val result = a / b.toDouble()
        println("divide $a + $b = $result")
        return result
    }
}