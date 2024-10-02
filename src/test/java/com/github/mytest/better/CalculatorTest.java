package com.github.mytest.better;

import com.github.mytest.original.Operation;
import com.github.mytest.better.operations.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    @Mock
    private AddOperation addOperation;

    @Mock
    private SubtractOperation subtractOperation;

    @Mock
    private MultiplyOperation multiplyOperation;

    @Mock
    private DivideOperation divideOperation;

    @Mock
    private PowOperation powOperation;

    private Map<Operation, OperationInterface> operationMaps;

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize operation strategies map
        operationMaps = new HashMap<>();
        operationMaps.put(Operation.ADD, addOperation);
        operationMaps.put(Operation.SUBTRACT, subtractOperation);
        operationMaps.put(Operation.MULTIPLY, multiplyOperation);
        operationMaps.put(Operation.DIVIDE, divideOperation);
        operationMaps.put(Operation.POW, powOperation);

        // Initialize calculatorService with an initial value and the mocked operation strategies
        calculatorService = new CalculatorService(24, operationMaps);
    }



    @Test
    public void testAddition() {
        // Arrange
        when(addOperation.operation(24, 3)).thenReturn(27);

        // Act
        calculatorService.chain(Operation.ADD, 3);
        Number result = calculatorService.getResult();

        // Assert
        assertEquals(27, result.doubleValue(), "Addition operation failed");
    }

    @Test
    public void testSubtraction() {
        // Arrange
        when(subtractOperation.operation(24, 2)).thenReturn(22);

        // Act
        calculatorService.chain(Operation.SUBTRACT, 2);
        Number result = calculatorService.getResult();

        // Assert
        assertEquals(22, result.doubleValue(), "Subtraction operation failed");
    }

    @Test
    public void testMultiplication() {
        // Arrange
        when(multiplyOperation.operation(24, 3)).thenReturn(72);

        // Act
        calculatorService.chain(Operation.MULTIPLY, 3);
        Number result = calculatorService.getResult();

        // Assert
        assertEquals(72, result.doubleValue(), "Addition operation failed");
    }

    @Test
    public void testDivision() {
        // Arrange
        when(divideOperation.operation(24, 3)).thenReturn(8);

        // Act
        calculatorService.chain(Operation.DIVIDE, 3);
        Number result = calculatorService.getResult();

        // Assert
        assertEquals(8, result.doubleValue(), "Addition operation failed");
    }

    @Test
    public void testPow() {
        // Arrange
        when(powOperation.operation(24, 1)).thenReturn(24);

        // Act
        calculatorService.chain(Operation.POW, 1);
        Number result = calculatorService.getResult();

        // Assert
        assertEquals(24, result.doubleValue(), "Pow operation failed");
    }

    @Test
    public void testChainedOperations() {
        // Arrange
        when(addOperation.operation(24, 3)).thenReturn(27);
        when(subtractOperation.operation(27, 4)).thenReturn(23);

        // Act
        calculatorService.chain(Operation.ADD, 3)
                .chain(Operation.SUBTRACT, 4);
        Number result = calculatorService.getResult();

        // Assert
        assertEquals(23, result.doubleValue(), "Chaining operations failed");
    }
}
