package com.kani.kcalc.core.engine;

import com.kani.kcalc.core.engine.exceptions.InvalidExpressionException;
import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;
import com.kani.kcalc.core.operations.Operation;
import com.kani.kcalc.core.utils.OperationUtil;

import java.util.List;
import java.util.Queue;

/**
 * Evaluates a given Expression
 */
public class CalcExpressionEvaluator {

    /**
     * Evaluate the expression from left to right using BODMAS rule
     * @param expression
     * @return Result of the evaluation
     * @throws InvalidExpressionException
     * @throws UnsupportedOperatorException
     */
    public double evaluate(Expression expression) throws InvalidExpressionException, UnsupportedOperatorException {
        List<Double> operands = expression.getOperands();
        List<Operation> operations = expression.getOperations();
        Queue<Integer> dMIndexes = OperationUtil.getDivisionOrMultiplicationIndexes(operations);


        //prioritize division and multiplication operations
        while (dMIndexes.size() > 0) {
            int dmIndex = dMIndexes.poll();
            Operation op = operations.get(dmIndex);
            double operand1 = operands.get(dmIndex);
            double operand2 = operands.get(dmIndex + 1);
            double result = op.exec(operand1, operand2);

            shrinkOperationsAndOperands(operands, operations, dmIndex, result);

            dMIndexes = OperationUtil.getDivisionOrMultiplicationIndexes(operations);
        }

        //all the division and multiplication operations are done by now
        //perform remaining addition and subtraction operations
        while (operations.size() > 0) {
            Operation op = operations.get(0);
            double operand1 = operands.get(0);
            double operand2 = operands.get(1);
            double result = op.exec(operand1, operand2);

            shrinkOperationsAndOperands(operands, operations, 0, result);
        }

        //it should be just 1 remaining operand, which is the result as the evaluation is done by now
        return operands.get(0);
    }

    private void shrinkOperationsAndOperands(List<Double> operands, List<Operation> operations, int dmIndex, double result) {
        operations.remove(dmIndex);
        operands.remove(dmIndex);
        operands.remove(dmIndex);
        operands.add(dmIndex, result);
    }
}