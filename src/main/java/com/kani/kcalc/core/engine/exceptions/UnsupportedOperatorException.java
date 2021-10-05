package com.kani.kcalc.core.engine.exceptions;

/**
 * Thrown to indicate that the application has attempted to evaluate expression with bad/unsupported operator
 */
public class UnsupportedOperatorException extends Exception{
    public UnsupportedOperatorException() {
    }

    public UnsupportedOperatorException(String message) {
        super(message);
    }

    public UnsupportedOperatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
