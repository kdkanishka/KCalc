package com.kani.kcalc.core.engine;

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
