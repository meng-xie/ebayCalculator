package com.github.mytest.v2;

import com.github.mytest.v1.Operation;
import com.github.mytest.v2.operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CalculatorConfig {

    @Bean
    public Map<Operation, OperationStrategy> operationStrategies(AddOperation addOperation,
                                                                 SubtractOperation subtractOperation,
                                                                 MultiplyOperation multiplyOperation,
                                                                 DivideOperation divideOperation,
                                                                 PowOperation powOperation) {
        Map<Operation, OperationStrategy> strategies = new HashMap<>();
        strategies.put(Operation.ADD, addOperation);
        strategies.put(Operation.SUBTRACT, subtractOperation);
        strategies.put(Operation.MULTIPLY, multiplyOperation);
        strategies.put(Operation.DIVIDE, divideOperation);
        strategies.put(Operation.POW, powOperation);
        // Add more operations here
        return strategies;
    }
}
