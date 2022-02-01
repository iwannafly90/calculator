package main.Calculator;

import java.io.IOException;
import java.util.Objects;

public abstract class Calculator {
    protected int addition(int a, int b) {
        return a + b;
    }

    protected int subtraction(int a, int b) {
        return a - b;
    }

    protected int multiplication(int a, int b) {
       return a * b;
    }

    protected int division(int a, int b) {
        return a / b;
    }

    public abstract void calculate(String a, String b, String operation) throws IOException;
}
