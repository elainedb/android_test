package com.example.myapplication.utils

class Calculator {

    fun add(a: Int, b: Int): Int = a + b

    fun subtract(a: Int, b: Int): Int = a - b

    fun multiply(a: Int, b: Int): Int = a * b

    fun divide(a: Int, b: Int): Int {
        if (b == 0) throw IllegalArgumentException("Cannot divide by zero")
        return a / b
    }

    fun power(base: Int, exponent: Int): Int {
        if (exponent < 0) throw IllegalArgumentException("Negative exponents not supported")
        var result = 1
        repeat(exponent) {
            result *= base
        }
        return result
    }

    fun factorial(n: Int): Long {
        if (n < 0) throw IllegalArgumentException("Factorial of negative number not supported")
        if (n == 0 || n == 1) return 1
        var result = 1L
        for (i in 2..n) {
            result *= i
        }
        return result
    }
}