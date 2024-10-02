package com.github.mytest.service.operations;

import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements OperationInterface {
    @Override
    public Number operation(Number num1, Number num2) {
        return num1.doubleValue() * num2.doubleValue();
    }
}