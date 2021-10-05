package com.kani.kcalc.core.operations;

import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;

/**
 * Operation factory helps to create a single operator instance from a given input in char format
 */
public class OperationFactory {

    private OperationFactory(){

    }

    /**
     *
     * @param operation in char format
     * @return Operation instance
     * @throws UnsupportedOperatorException
     */
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
