package core.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    @Test
    void when_two_operands_are_provided_it_should_apply_multiply(){
        Operation addition = new Multiplication();
        double exec = addition.exec(0.08, 0.5);
        assertEquals(0.04, exec);
    }
}