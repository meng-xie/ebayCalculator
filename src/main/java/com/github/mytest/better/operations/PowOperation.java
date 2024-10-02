package com.github.mytest.better.operations;

import org.springframework.stereotype.Component;

@Component
public class PowOperation implements OperationStrategy {
    @Override
    public Number apply(Number num1, Number num2) {
        return Math.pow(num1.doubleValue(), num2.doubleValue());
    }
}
