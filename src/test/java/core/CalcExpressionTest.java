package core;

import core.operations.Division;
import core.operations.Multiplication;
import core.operations.Operation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalcExpressionTest {

    @Test
    void getOperands() {
        CalcExpression calcExpression = new CalcExpression("5-2*6/3");
        List<Long> operands = calcExpression.getOperands();
        assertEquals(operands.size(), 4);
        assertAll("operands",
                () -> assertEquals(operands.get(0), java.util.Optional.of(5)),
                () -> assertEquals(operands.get(0), java.util.Optional.of(2)),
                () -> assertEquals(operands.get(0), java.util.Optional.of(6)),
                () -> assertEquals(operands.get(0), java.util.Optional.of(3))
        );
    }

    @Test
    void getOperators() {
        CalcExpression calcExpression = new CalcExpression("5-2*6/3");
        List<Operation> operators = calcExpression.getOperators();
        assertEquals(operators.size(),3);

        assertTrue(operators.get(0) instanceof Subtraction);
        assertTrue(operators.get(0) instanceof Multiplication);
        assertTrue(operators.get(0) instanceof Division);
    }
}