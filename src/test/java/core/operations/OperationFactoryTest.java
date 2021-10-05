package core.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationFactoryTest {
    @Test
    void testAddition(){
        Operation operation = OperationFactory.getOperation('+');
        assertTrue(operation instanceof Addition);
    }

    @Test
    void testSubtraction(){
        Operation operation = OperationFactory.getOperation('-');
        assertTrue(operation instanceof Subtraction);
    }

    @Test
    void testMultiplication(){
        Operation operation = OperationFactory.getOperation('*');
        assertTrue(operation instanceof Multiplication);
    }

    @Test
    void testDivision(){
        Operation operation = OperationFactory.getOperation('/');
        assertTrue(operation instanceof Division);
    }

    @Test
    void testUnsupportedException(){
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            OperationFactory.getOperation('^');
        });

        assertEquals("Unknown Operator, ^",exception.getMessage());
    }
}