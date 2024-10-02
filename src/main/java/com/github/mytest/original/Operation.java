package com.github.mytest.original;

public enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, POW;

    public static Number applyOperation(Operation operation, Number num1, Number num2) {
        return switch (operation) {
            case ADD -> Double.valueOf(num1.doubleValue() + num2.doubleValue());
            case SUBTRACT -> Double.valueOf(num1.doubleValue() - num2.doubleValue());
            case MULTIPLY -> Double.valueOf(num1.doubleValue() * num2.doubleValue());
            case DIVIDE -> {
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                yield Double.valueOf(num1.doubleValue() / num2.doubleValue());
            }
            case POW -> Double.valueOf(Math.pow(num1.doubleValue(), num2.doubleValue()));
            default -> throw new UnsupportedOperationException("Operation not supported.");
        };
    }
}
