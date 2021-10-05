package com.kani.kcalc.core.engine.exceptions;

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
