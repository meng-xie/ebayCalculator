package com.github.mytest.better.operations;
import org.springframework.stereotype.Component;

@Component
public class SubtractOperation implements OperationInterface {
    @Override
    public Number operation(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
