package com.example.myapplication.utils

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun add_shouldReturnCorrectSum() {
        assertEquals(5, calculator.add(2, 3))
        assertEquals(-1, calculator.add(-5, 4))
        assertEquals(0, calculator.add(-10, 10))
    }

    @Test
    fun subtract_shouldReturnCorrectDifference() {
        assertEquals(2, calculator.subtract(5, 3))
        assertEquals(-7, calculator.subtract(3, 10))
        assertEquals(0, calculator.subtract(5, 5))
    }

    @Test
    fun multiply_shouldReturnCorrectProduct() {
        assertEquals(15, calculator.multiply(3, 5))
        assertEquals(-12, calculator.multiply(-3, 4))
        assertEquals(0, calculator.multiply(0, 100))
    }

    @Test
    fun divide_shouldReturnCorrectQuotient() {
        assertEquals(3, calculator.divide(15, 5))
        assertEquals(-2, calculator.divide(-10, 5))
        assertEquals(0, calculator.divide(0, 5))
    }

    @Test(expected = IllegalArgumentException::class)
    fun divide_shouldThrowExceptionWhenDividingByZero() {
        calculator.divide(10, 0)
    }

    @Test
    fun power_shouldReturnCorrectResult() {
        assertEquals(8, calculator.power(2, 3))
        assertEquals(1, calculator.power(5, 0))
        assertEquals(25, calculator.power(5, 2))
        assertEquals(1, calculator.power(1, 100))
    }

    @Test(expected = IllegalArgumentException::class)
    fun power_shouldThrowExceptionForNegativeExponent() {
        calculator.power(2, -1)
    }

    @Test
    fun factorial_shouldReturnCorrectResult() {
        assertEquals(1, calculator.factorial(0))
        assertEquals(1, calculator.factorial(1))
        assertEquals(2, calculator.factorial(2))
        assertEquals(6, calculator.factorial(3))
        assertEquals(24, calculator.factorial(4))
        assertEquals(120, calculator.factorial(5))
    }

    @Test(expected = IllegalArgumentException::class)
    fun factorial_shouldThrowExceptionForNegativeNumber() {
        calculator.factorial(-1)
    }
}