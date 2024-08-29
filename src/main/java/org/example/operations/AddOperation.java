package org.example.operations;

import org.example.core.Operation;
import org.example.core.OperationType;

public class AddOperation implements OperationType {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}