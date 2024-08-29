package org.example.core;

import org.example.operations.AddOperation;
import org.example.operations.DivideOperation;
import org.example.operations.MultiplyOperation;
import org.example.operations.SubtractOperation;
import org.example.exceptions.UnsupportedOperationException;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static final Map<Operation, OperationType> operations = new HashMap<>();

    static {
        operations.put(Operation.ADD, new AddOperation());
        operations.put(Operation.SUBTRACT, new SubtractOperation());
        operations.put(Operation.MULTIPLY, new MultiplyOperation());
        operations.put(Operation.DIVIDE, new DivideOperation());
    }

    public static OperationType getOperation(Operation operation) {
        if (operation == null || !operations.containsKey(operation)) {
            throw new UnsupportedOperationException("Operation not supported: " + operation);
        }
        return operations.get(operation);
    }
}