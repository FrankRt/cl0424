package org.example.test4.exception;

public class RentalPeriodOutOfRangeException extends Exception {
    public RentalPeriodOutOfRangeException(String errorMessage) {
        super(errorMessage);
    }
}
