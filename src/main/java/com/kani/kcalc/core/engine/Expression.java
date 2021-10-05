package com.kani.kcalc.core.engine;

import com.kani.kcalc.core.engine.exceptions.InvalidExpressionException;
import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;
import com.kani.kcalc.core.operations.Operation;

import java.util.List;

public interface Expression {
    List<Double> getOperands() throws InvalidExpressionException;
    List<Operation> getOperations() throws UnsupportedOperatorException;
}
