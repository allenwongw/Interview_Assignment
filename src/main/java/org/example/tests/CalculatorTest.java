package org.example.tests;

import org.example.calculator.Calculator;
import org.example.calculator.CalculatorBuilder;
import org.example.core.Operation;
import org.example.core.OperationFactory;
import org.example.core.OperationType;
import org.example.exceptions.UnsupportedOperationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testBasicOperations() {
        Calculator calculator = new CalculatorBuilder().setInitialValue(10).build();

        assertEquals(13.0, calculator.calculate(Operation.ADD, 10, 3).doubleValue());
        assertEquals(5.0, calculator.calculate(Operation.SUBTRACT, 10, 5).doubleValue());
        assertEquals(50.0, calculator.calculate(Operation.MULTIPLY, 10, 5).doubleValue());
        assertEquals(2.5, calculator.calculate(Operation.DIVIDE, 10, 4).doubleValue());
    }

    @Test
    public void testChainingOperations() {
        Calculator calculator = new CalculatorBuilder().setInitialValue(10).build();

        Number result = calculator
                .perform(Operation.ADD, 5)
                .perform(Operation.SUBTRACT, 3)
                .perform(Operation.MULTIPLY, 2)
                .perform(Operation.DIVIDE, 4)
                .getResult();

        assertEquals(6.0, result.doubleValue());
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new CalculatorBuilder().setInitialValue(10).build();

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 10, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            Operation operationType = null;
            try {
                operationType = Operation.valueOf("MODULO");
            } catch (IllegalArgumentException e) {
                throw new UnsupportedOperationException("Operation not supported: MODULO");
            }
            OperationFactory.getOperation(operationType);
        });
    }
}