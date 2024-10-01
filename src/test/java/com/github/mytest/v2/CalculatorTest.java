package com.github.mytest.v2;

import com.github.mytest.v1.Operation;
import com.github.mytest.v2.operations.*;
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

    private Map<Operation, OperationStrategy> operationStrategies;

    @InjectMocks
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize operation strategies map
        operationStrategies = new HashMap<>();
        operationStrategies.put(Operation.ADD, addOperation);
        operationStrategies.put(Operation.SUBTRACT, subtractOperation);
        operationStrategies.put(Operation.MULTIPLY, multiplyOperation);
        operationStrategies.put(Operation.DIVIDE, divideOperation);
        operationStrategies.put(Operation.POW, powOperation);

        // Initialize calculator with an initial value and the mocked operation strategies
        calculator = new Calculator(24, operationStrategies);
    }



    @Test
    public void testAddition() {
        // Arrange
        when(addOperation.apply(24, 3)).thenReturn(27);

        // Act
        calculator.chain(Operation.ADD, 3);
        Number result = calculator.getResult();

        // Assert
        assertEquals(27, result.doubleValue(), "Addition operation failed");
    }

    @Test
    public void testSubtraction() {
        // Arrange
        when(subtractOperation.apply(24, 2)).thenReturn(22);

        // Act
        calculator.chain(Operation.SUBTRACT, 2);
        Number result = calculator.getResult();

        // Assert
        assertEquals(22, result.doubleValue(), "Subtraction operation failed");
    }

    @Test
    public void testMultiplication() {
        // Arrange
        when(multiplyOperation.apply(24, 3)).thenReturn(72);

        // Act
        calculator.chain(Operation.MULTIPLY, 3);
        Number result = calculator.getResult();

        // Assert
        assertEquals(72, result.doubleValue(), "Addition operation failed");
    }

    @Test
    public void testDivision() {
        // Arrange
        when(divideOperation.apply(24, 3)).thenReturn(8);

        // Act
        calculator.chain(Operation.DIVIDE, 3);
        Number result = calculator.getResult();

        // Assert
        assertEquals(8, result.doubleValue(), "Addition operation failed");
    }

    @Test
    public void testPow() {
        // Arrange
        when(powOperation.apply(24, 1)).thenReturn(24);

        // Act
        calculator.chain(Operation.POW, 1);
        Number result = calculator.getResult();

        // Assert
        assertEquals(24, result.doubleValue(), "Pow operation failed");
    }

    @Test
    public void testChainedOperations() {
        // Arrange
        when(addOperation.apply(24, 3)).thenReturn(27);
        when(subtractOperation.apply(27, 4)).thenReturn(23);

        // Act
        calculator.chain(Operation.ADD, 3)
                .chain(Operation.SUBTRACT, 4);
        Number result = calculator.getResult();

        // Assert
        assertEquals(23, result.doubleValue(), "Chaining operations failed");
    }
}
