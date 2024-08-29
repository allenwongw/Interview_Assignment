package org.example.calculator;

import org.example.core.Operation;
import org.example.core.OperationFactory;
import org.example.core.OperationType;

public class Calculator {
    private Number currentValue;

    public Calculator(Number initialValue) {
        this.currentValue = initialValue;
    }

    public Number calculate(Operation operation, Number num1, Number num2) {
        OperationType o = OperationFactory.getOperation(operation);
        return o.apply(num1, num2);
    }

    public Calculator perform(Operation operation, Number value) {
        this.currentValue = OperationFactory.getOperation(operation).apply(this.currentValue, value);
        return this;
    }

    public Number getResult() {
        return this.currentValue;
    }
}