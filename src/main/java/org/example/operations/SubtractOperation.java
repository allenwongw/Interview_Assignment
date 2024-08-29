package org.example.operations;

import org.example.core.Operation;

public class SubtractOperation implements Operation {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}