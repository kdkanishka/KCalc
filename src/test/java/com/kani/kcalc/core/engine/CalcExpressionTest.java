package com.kani.kcalc.core.engine;

import com.kani.kcalc.core.engine.CalcExpression;
import com.kani.kcalc.core.engine.InvalidExpressionException;
import com.kani.kcalc.core.operations.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalcExpressionTest {

    @Test
    void getOperands() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("5.2-2*6/3");
        List<Double> operands = calcExpression.getOperands();
        assertEquals(operands.size(), 4);

        assertEquals(operands.get(0).doubleValue(),5.2);
        assertEquals(operands.get(1).doubleValue(),2);
        assertEquals(operands.get(2).doubleValue(),6);
        assertEquals(operands.get(3).doubleValue(),3);


    }

    @Test
    void getOperators() {
        CalcExpression calcExpression = new CalcExpression("5-2*6/3");
        List<Operation> operators = calcExpression.getOperations();

        assertEquals(operators.size(),3);
        assertTrue(operators.get(0) instanceof Subtraction);
        assertTrue(operators.get(1) instanceof Multiplication);
        assertTrue(operators.get(2) instanceof Division);
    }

    @Test
    void operatorsInLongExpression() {
        CalcExpression calcExpression = new CalcExpression("5-2*6/3+1+6/2*8");
        List<Operation> operators = calcExpression.getOperations();

        assertEquals(operators.size(),7);
        assertTrue(operators.get(0) instanceof Subtraction);
        assertTrue(operators.get(1) instanceof Multiplication);
        assertTrue(operators.get(2) instanceof Division);
        assertTrue(operators.get(3) instanceof Addition);
        assertTrue(operators.get(4) instanceof Addition);
        assertTrue(operators.get(5) instanceof Division);
        assertTrue(operators.get(6) instanceof Multiplication);
    }
    
    @Test
    void operandsInLongExpression() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("5.2-2*6/3+1.75+6/2*8");
        List<Double> operands = calcExpression.getOperands();
        assertEquals(operands.size(), 8);

        assertEquals(operands.get(0).doubleValue(),5.2);
        assertEquals(operands.get(1).doubleValue(),2);
        assertEquals(operands.get(2).doubleValue(),6);
        assertEquals(operands.get(3).doubleValue(),3);
        assertEquals(operands.get(4).doubleValue(),1.75);
        assertEquals(operands.get(5).doubleValue(),6);
        assertEquals(operands.get(6).doubleValue(),2);
        assertEquals(operands.get(7).doubleValue(),8);
    }
}