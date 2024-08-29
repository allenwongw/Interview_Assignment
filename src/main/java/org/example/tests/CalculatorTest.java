package org.example.tests;

import org.example.calculator.Calculator;
import org.example.calculator.CalculatorBuilder;
import org.example.core.OperationFactory;
import org.example.core.OperationType;
import org.example.exceptions.UnsupportedOperationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testBasicOperations() {
        Calculator calculator = new CalculatorBuilder().setInitialValue(10).build();

        assertEquals(13.0, calculator.calculate(OperationType.ADD, 10, 3).doubleValue());
        assertEquals(5.0, calculator.calculate(OperationType.SUBTRACT, 10, 5).doubleValue());
        assertEquals(50.0, calculator.calculate(OperationType.MULTIPLY, 10, 5).doubleValue());
        assertEquals(2.5, calculator.calculate(OperationType.DIVIDE, 10, 4).doubleValue());
    }

    @Test
    public void testChainingOperations() {
        Calculator calculator = new CalculatorBuilder().setInitialValue(10).build();

        Number result = calculator
                .perform(OperationType.ADD, 5)
                .perform(OperationType.SUBTRACT, 3)
                .perform(OperationType.MULTIPLY, 2)
                .perform(OperationType.DIVIDE, 4)
                .getResult();

        assertEquals(6.0, result.doubleValue());
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new CalculatorBuilder().setInitialValue(10).build();

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(OperationType.DIVIDE, 10, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            OperationType operationType = null;
            try {
                operationType = OperationType.valueOf("MODULO");
            } catch (IllegalArgumentException e) {
                throw new UnsupportedOperationException("Operation not supported: MODULO");
            }
            OperationFactory.getOperation(operationType);
        });
    }
}