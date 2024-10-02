package com.github.mytest.base;

public class Calculator {
    private Number currentValue;

    public Calculator(Number initialValue) {
        this.currentValue = initialValue;
    }

    // Perform a single operation
    public Number calculate(Operation operation, Number num1, Number num2) {
        return Operation.applyOperation(operation, num1, num2);
    }

    // Chaining operations
    public Calculator chain(Operation operation, Number value) {
        this.currentValue = Operation.applyOperation(operation, this.currentValue, value);
        return this;
    }

    // Get the final result after chaining operations
    public Number getResult() {
        return this.currentValue;
    }

    // Extensibility - can add more operations without changing this class
}
