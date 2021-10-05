package com.kani.kcalc.core.operations;

/**
 * Single Mathematical operation
 */
public interface Operation {
    /**
     * Executes the relevant mathematical operation on given operands.
     * @param n1 - operand 1
     * @param n2 - operand 2
     * @return
     */
    double exec(double n1, double n2);
}
