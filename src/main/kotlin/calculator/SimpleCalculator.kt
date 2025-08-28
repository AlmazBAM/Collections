package calculator

class SimpleCalculator : Calculator {

    override fun sum(a: Int, b: Int): Int {
        return a + b
    }

    override fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    override fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    override fun divide(a: Int, b: Int): Double {
        return a / b.toDouble()
    }

}