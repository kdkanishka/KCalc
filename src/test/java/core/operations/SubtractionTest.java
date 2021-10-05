package core.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {
    @Test
    void when_two_operands_are_provided_it_should_apply_subtract(){
        Operation addition = new Subtraction();
        double exec = addition.exec(5.55, 0.55);
        assertEquals(5.00, exec);
    }
}