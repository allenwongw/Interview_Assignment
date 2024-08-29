package org.example.core;

import org.example.operations.AddOperation;
import org.example.operations.DivideOperation;
import org.example.operations.MultiplyOperation;
import org.example.operations.SubtractOperation;
import org.example.exceptions.UnsupportedOperationException;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static final Map<OperationType, Operation> operations = new HashMap<>();

    static {
        operations.put(OperationType.ADD, new AddOperation());
        operations.put(OperationType.SUBTRACT, new SubtractOperation());
        operations.put(OperationType.MULTIPLY, new MultiplyOperation());
        operations.put(OperationType.DIVIDE, new DivideOperation());
    }

    public static Operation getOperation(OperationType operationType) {
        if (operationType == null || !operations.containsKey(operationType)) {
            throw new UnsupportedOperationException("Operation not supported: " + operationType);
        }
        return operations.get(operationType);
    }
}