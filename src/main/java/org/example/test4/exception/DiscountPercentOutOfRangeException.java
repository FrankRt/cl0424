package org.example.test4.exception;

public class DiscountPercentOutOfRangeException extends Exception {
    public DiscountPercentOutOfRangeException(String errorMessage) {
        super(errorMessage);
    }
}
