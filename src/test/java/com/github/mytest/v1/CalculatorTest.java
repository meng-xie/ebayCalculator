package com.github.mytest.v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator(Double.valueOf(0.0));
        Number result = calculator.chain(Operation.ADD, 5).getResult();
        assertEquals(5, result.doubleValue());
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator(10);
        Number result = calculator.chain(Operation.SUBTRACT, 4).getResult();
        assertEquals(6, result.doubleValue());
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator(10);
        Number result = calculator.chain(Operation.MULTIPLY, 4).getResult();
        assertEquals(40, result.doubleValue());
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator(10);
        Number result = calculator.chain(Operation.DIVIDE, 5).getResult();
        assertEquals(2, result.doubleValue());
    }

    @Test
    public void testPow() {
        Calculator calculator = new Calculator(2);
        Number result = calculator.chain(Operation.POW, 3).getResult();
        assertEquals(8, result.doubleValue());
    }

    @Test
    public void testChainingOperations() {
        Calculator calculator = new Calculator(5);
        Number result = calculator.chain(Operation.ADD, 3)
                .chain(Operation.MULTIPLY, 2)
                .getResult();
        assertEquals(16, result.doubleValue());
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator(5);
        assertThrows(ArithmeticException.class, () -> {
            calculator.chain(Operation.DIVIDE, 0).getResult();
        });
    }
}
