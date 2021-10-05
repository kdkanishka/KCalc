package com.kani.kcalc.core.operations;

/**
 * Represents mathematical subtraction (-)
 */
public class Subtraction implements Operation {
    @Override
    public double exec(double n1, double n2) {
        return n1 - n2;
    }
}
