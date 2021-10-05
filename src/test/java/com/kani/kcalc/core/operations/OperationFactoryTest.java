package com.kani.kcalc.core.operations;

import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationFactoryTest {
    @Test
    void testAddition() throws UnsupportedOperatorException {
        Operation operation = OperationFactory.getOperation('+');
        assertTrue(operation instanceof Addition);
    }

    @Test
    void testSubtraction() throws UnsupportedOperatorException {
        Operation operation = OperationFactory.getOperation('-');
        assertTrue(operation instanceof Subtraction);
    }

    @Test
    void testMultiplication() throws UnsupportedOperatorException {
        Operation operation = OperationFactory.getOperation('*');
        assertTrue(operation instanceof Multiplication);
    }

    @Test
    void testDivision() throws UnsupportedOperatorException {
        Operation operation = OperationFactory.getOperation('/');
        assertTrue(operation instanceof Division);
    }

    @Test
    void testUnsupportedException(){
        Exception exception = assertThrows(UnsupportedOperatorException.class, () -> {
            OperationFactory.getOperation('^');
        });

        assertEquals("Unknown Operator, ^",exception.getMessage());
    }
}