package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    public void addInteger() {
        assertEquals("1 + 1 = 2", calc.add(1, 1));
        assertEquals("123 + 456 = 579", calc.add(123, 456));
    }

    @Test
    public void subtractInteger() {
        assertEquals("23 - 52 = -29", calc.subtract(23, 52));
        assertEquals("50 - 32 = 18", calc.subtract(50, 32));
    }

    @Test
    public void multiplyInteger() {
        assertEquals("34 * 2 = 68", calc.multiply(34, 2));
        assertEquals("5 * 20 = 100", calc.multiply(5, 20));
    }

    @Test
    public void divideInteger() {
        assertEquals("12 / 3 = 4", calc.divide(12, 3));
        assertEquals("12 / 7 = 1", calc.divide(12, 7));
    }

    @Test
    public void addDouble() {
        assertEquals("3.4 + 2.3 = 5.70", calc.add(3.4, 2.3));
        assertEquals("15.6 + 4.4 = 20.00", calc.add(15.6, 4.4));
    }

    @Test
    public void subtractDouble() {
        assertEquals("5.5 - 0.5 = 5.00", calc.subtract(5.5, 0.5));
        assertEquals("12.4 - 5.7 = 6.70", calc.subtract(12.4, 5.7));
    }

    @Test
    public void multiplyDouble() {
        assertEquals("6.7 * 4.4 = 29.48", calc.multiply(6.7, 4.4));
        assertEquals("51.0 * 0.1 = 5.10", calc.multiply(51.0, 0.1));
    }

    @Test
    public void divideDouble() {
        assertEquals("10.8 / 2.2 = 4.91", calc.divide(10.8, 2.2));
        assertEquals("8.8 / 2.2 = 4.00", calc.divide(8.8, 2.2));
    }
}