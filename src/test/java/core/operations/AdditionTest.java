package core.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @Test
    void when_two_operands_are_provided_it_should_apply_addition(){
        Operation addition = new Addition();
        double exec = addition.exec(1.5, 0.5);
        assertEquals(2.0, exec);
    }
}