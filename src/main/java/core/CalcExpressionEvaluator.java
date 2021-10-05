package core;

import core.operations.Operation;
import core.utils.OperationUtil;

import java.util.List;
import java.util.Queue;

public class CalcExpressionEvaluator {

    public double evaluate(CalcExpression calcExpression) throws InvalidExpressionException {
        List<Double> operands = calcExpression.getOperands();
        List<Operation> operations = calcExpression.getOperations();
        Queue<Integer> dMIndexes = OperationUtil.getDivisionOrMultiplicationIndexes(operations);


        //prioritize D&M operations
        while (dMIndexes.size() > 0) {
            int dmIndex = dMIndexes.poll();
            Operation op = operations.get(dmIndex);
            double operand1 = operands.get(dmIndex);
            double operand2 = operands.get(dmIndex + 1);
            double result = op.exec(operand1, operand2);

            operations.remove(dmIndex);
            operands.remove(dmIndex);
            operands.remove(dmIndex);

            operands.add(dmIndex, result);

            System.out.println(operands);
            System.out.println(operations);
            dMIndexes = OperationUtil.getDivisionOrMultiplicationIndexes(operations);
        }

        //perform remaining A&S operations
        while(operations.size() > 0){
            Operation op = operations.get(0);
            double operand1 = operands.get(0);
            double operand2 = operands.get(1);
            double result = op.exec(operand1, operand2);

            operations.remove(0);
            operands.remove(0);
            operands.remove(0);

            operands.add(0, result);

            System.out.println(operands);
            System.out.println(operations);
        }

        return operands.get(0);
    }
}