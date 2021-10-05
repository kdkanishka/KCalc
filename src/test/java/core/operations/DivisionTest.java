package core.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    @Test
    void when_two_operands_are_provided_it_should_apply_division(){
        Operation addition = new Division();
        double exec = addition.exec(2.5, 0.5);
        assertEquals(5.0, exec);
    }
}