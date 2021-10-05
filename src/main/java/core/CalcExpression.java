package core;

import core.operations.Division;
import core.operations.Multiplication;
import core.operations.Operation;
import core.operations.OperationFactory;

import java.util.*;
import java.util.stream.Collectors;

public class CalcExpression {
    private String expressionText;
    private List<Integer> divisionOrMultiplicationIndexes=new ArrayList<>();

    public CalcExpression(String expressionText) {
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
            throw new InvalidExpressionException("Invalid expression, " + e.getMessage());
        }
    }

    /**
     * Process the expression and extract operators from it
     * ie. 5-2*6/3
     *
     * @return list of operators [-,*,/]
     */
    public List<Operation> getOperations() {
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
