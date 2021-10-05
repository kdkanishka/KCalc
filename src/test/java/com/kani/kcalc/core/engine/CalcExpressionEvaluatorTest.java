package com.kani.kcalc.core.engine;

import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalcExpressionEvaluatorTest {

    @Test
    void evaluate_example1() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("2+3+3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(calcExpression);
        assertEquals(8, result);
    }

    @Test
    void evaluate_example2() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("2+3-3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(calcExpression);
        assertEquals(2, result);
    }

    @Test
    void evaluate_example3() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("5/2-3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(calcExpression);
        assertEquals(-0.5, result);
    }

    @Test
    void evaluate_long_expression_with_decimal_points_and_all_operators() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("5.2-2*6/3+1.75+6/2*8");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(calcExpression);
        assertEquals(26.95, result);
    }

    @Test
    void evaluate_expression_with_no_multiplication_and_division() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("7+4-1+9-10+33.7772+678-101.6734+345");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(calcExpression);
        assertEquals(964.1038, result);
    }

    @Test
    void evaluate_expression_with_no_addition_and_subtraction() throws InvalidExpressionException {
        CalcExpression calcExpression = new CalcExpression("445.56*110.65/234.223/0.1*100");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(calcExpression);

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String formatted = df.format(result);
        assertEquals("210488.3551", formatted);
    }

    @Test
    void evaluate_bad_expression(){
        CalcExpression calcExpression = new CalcExpression("1+3+10^2/3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        Exception exception = assertThrows(InvalidExpressionException.class, () -> {
            evaluator.evaluate(calcExpression);
        });

        assertEquals("Invalid expression, For input string: \"10^2\"", exception.getMessage());
    }
}