package org.example.calculator;

public class CalculatorBuilder {
    private Number initialValue;

    public CalculatorBuilder setInitialValue(Number initialValue) {
        this.initialValue = initialValue;
        return this;
    }

    public Calculator build() {
        return new Calculator(initialValue);
    }
}