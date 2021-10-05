package com.kani.kcalc.core.engine;

import com.kani.kcalc.core.engine.exceptions.InvalidExpressionException;
import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicExpressionEvaluatorTest {

    @Test
    void evaluate_example1() throws InvalidExpressionException, UnsupportedOperatorException {
        BasicExpression basicExpression = new BasicExpression("2+3+3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(basicExpression);
        assertEquals(8, result);
    }

    @Test
    void evaluate_example2() throws InvalidExpressionException, UnsupportedOperatorException {
        BasicExpression basicExpression = new BasicExpression("2+3-3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(basicExpression);
        assertEquals(2, result);
    }

    @Test
    void evaluate_example3() throws InvalidExpressionException, UnsupportedOperatorException {
        BasicExpression basicExpression = new BasicExpression("5/2-3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(basicExpression);
        assertEquals(-0.5, result);
    }

    @Test
    void evaluate_long_expression_with_decimal_points_and_all_operators() throws InvalidExpressionException, UnsupportedOperatorException {
        BasicExpression basicExpression = new BasicExpression("5.2-2*6/3+1.75+6/2*8");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(basicExpression);
        assertEquals(26.95, result);
    }

    @Test
    void evaluate_expression_with_no_multiplication_and_division() throws InvalidExpressionException, UnsupportedOperatorException {
        BasicExpression basicExpression = new BasicExpression("7+4-1+9-10+33.7772+678-101.6734+345");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(basicExpression);
        assertEquals(964.1038, result);
    }

    @Test
    void evaluate_expression_with_no_addition_and_subtraction() throws InvalidExpressionException, UnsupportedOperatorException {
        BasicExpression basicExpression = new BasicExpression("445.56*110.65/234.223/0.1*100");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        double result = evaluator.evaluate(basicExpression);

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String formatted = df.format(result);
        assertEquals("210488.3551", formatted);
    }

    @Test
    void evaluate_bad_expression(){
        BasicExpression basicExpression = new BasicExpression("1+3+10^2/3");
        CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
        Exception exception = assertThrows(InvalidExpressionException.class, () -> {
            evaluator.evaluate(basicExpression);
        });

        assertEquals("Invalid expression, For input string: \"10^2\"", exception.getMessage());
    }
}