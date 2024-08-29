package org.example.operations;

import org.example.core.Operation;

public class AddOperation implements Operation {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}