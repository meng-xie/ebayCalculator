package com.github.mytest.v2.operations;
import org.springframework.stereotype.Component;

@Component
public class SubtractOperation implements OperationStrategy {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
