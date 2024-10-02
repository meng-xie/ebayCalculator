package com.github.mytest.better;

import com.github.mytest.original.Operation;
import com.github.mytest.better.operations.OperationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Calculator {
    private Number currentValue;

    private final Map<Operation, OperationInterface> operationMaps;

    @Autowired
    public Calculator(Number initialValue, Map<Operation, OperationInterface> operationMaps) {
        this.currentValue = initialValue;
        this.operationMaps = operationMaps;
    }

    // Perform a single operation with IoC injected strategies
    public Number calculate(Operation operation, Number num1, Number num2) {
        OperationInterface strategy = operationMaps.get(operation);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported.");
        }
        return strategy.operation(num1, num2);
    }

    // Chaining operations
    public Calculator chain(Operation operation, Number value) {
        this.currentValue = calculate(operation, this.currentValue, value);
        return this;
    }

    public Number getResult() {
        return this.currentValue;
    }
}
