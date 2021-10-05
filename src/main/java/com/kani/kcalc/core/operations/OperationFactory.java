package com.kani.kcalc.core.operations;

public class OperationFactory {

    public static Operation getOperation(char operation) {
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
                throw new IllegalStateException("Unknown Operator, " + operation);
        }
        return op;
    }
}
