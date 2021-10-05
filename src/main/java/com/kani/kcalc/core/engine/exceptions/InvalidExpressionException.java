package com.kani.kcalc.core.engine.exceptions;

/**
 * Thrown to indicate that the application has attempted to evaluate incorrect expression
 */
public class InvalidExpressionException extends Exception{
    public InvalidExpressionException() {
    }

    public InvalidExpressionException(String message) {
        super(message);
    }

    public InvalidExpressionException(String message, Throwable cause) {
        super(message, cause);
    }
}
