package com.github.mytest.service;

import com.github.mytest.base.Operation;
import com.github.mytest.service.operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CalculatorConfig {

    @Bean
    public Map<Operation, OperationInterface> operationMaps(AddOperation addOperation,
                                                                  SubtractOperation subtractOperation,
                                                                  MultiplyOperation multiplyOperation,
                                                                  DivideOperation divideOperation,
                                                                  PowOperation powOperation) {
        Map<Operation, OperationInterface> operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, addOperation);
        operationMap.put(Operation.SUBTRACT, subtractOperation);
        operationMap.put(Operation.MULTIPLY, multiplyOperation);
        operationMap.put(Operation.DIVIDE, divideOperation);
        operationMap.put(Operation.POW, powOperation);
        // Add more operations here
        return operationMap;
    }
}
