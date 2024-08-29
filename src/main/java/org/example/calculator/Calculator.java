package org.example.calculator;

import org.example.core.Operation;
import org.example.core.OperationFactory;
import org.example.core.OperationType;

public class Calculator {
    private Number currentValue;

    public Calculator(Number initialValue) {
        this.currentValue = initialValue;
    }

    public Number calculate(OperationType operationType, Number num1, Number num2) {
        Operation operation = OperationFactory.getOperation(operationType);
        return operation.apply(num1, num2);
    }

    public Calculator perform(OperationType operationType, Number value) {
        this.currentValue = OperationFactory.getOperation(operationType).apply(this.currentValue, value);
        return this;
    }

    public Number getResult() {
        return this.currentValue;
    }
}