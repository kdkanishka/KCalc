package com.kani.kcalc.core.engine;

import com.kani.kcalc.core.engine.exceptions.InvalidExpressionException;
import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;
import com.kani.kcalc.core.operations.Operation;
import com.kani.kcalc.core.operations.OperationFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Basic mathematical expression with the support for basic math operators / , * , + , -
 */
public class BasicExpression implements Expression{
    private String expressionText;

    public BasicExpression(String expressionText) {
        this.expressionText = expressionText;
    }

    /**
     * Process the expression and extract operands from it
     * ie. 5-2*6/3
     *
     * @return list of operands [5,2,6,3]
     */
    public List<Double> getOperands() throws InvalidExpressionException {
        try {
            String[] split = expressionText.split("[\\/|\\*|+|-]");
            List<Double> operandList = Arrays.stream(split)
                    .map(elem -> Double.parseDouble(elem))
                    .collect(Collectors.toCollection(LinkedList<Double>::new));
            return operandList;
        }catch (NumberFormatException e){
            throw new InvalidExpressionException("Invalid expression, " + e.getMessage(), e);
        }
    }

    /**
     * Process the expression and extract operators from it
     * ie. 5-2*6/3
     *
     * @return list of operators [-,*,/]
     */
    public List<Operation> getOperations() throws UnsupportedOperatorException {
        final List<Character> supportedOperators = Arrays.asList('/', '*', '+', '-');
        final List<Operation> operators = new LinkedList<>();
        for (int i = 0; i < expressionText.length(); i++) {
            char operationAsChar = expressionText.charAt(i);
            if (supportedOperators.contains(operationAsChar)) {
                //get operation instance from the factory
                Operation operation = OperationFactory.getOperation(operationAsChar);
                operators.add(operation);
            }
        }
        return operators;
    }
}
