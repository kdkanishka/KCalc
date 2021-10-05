package com.kani.kcalc.core.operations;

import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;

public class OperationFactory {

    public static Operation getOperation(char operation) throws UnsupportedOperatorException {
        Operation op;
        switch (operation) {
            case '/':
                op = new Division();
                break;
            case '*':
                op= new Multiplication();
                break;
            case '+':
                op = new Addition();
                break;
            case '-' :
                op = new Subtraction();
                break;
            default:
                throw new UnsupportedOperatorException("Unknown Operator, " + operation);
        }
        return op;
    }
}
