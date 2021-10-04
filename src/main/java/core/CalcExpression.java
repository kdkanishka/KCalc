package core;

import core.operations.Operation;

import java.util.List;

public class CalcExpression {
    private String expressionText;

    public CalcExpression(String expressionText) {
        this.expressionText = expressionText;
    }

    /**
     * Process the expression and extract operands from it
     * @return list of operands
     */
    public List<Long> getOperands(){

        return null;
    }

    /**
     * Process the expression and extract operators from it
     * @return list of operators
     */
    public List<Operation> getOperators(){

        return null;
    }
}
