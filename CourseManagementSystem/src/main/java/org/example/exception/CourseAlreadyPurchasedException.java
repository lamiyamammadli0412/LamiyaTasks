package org.example.exception;

public class CourseAlreadyPurchasedException extends RuntimeException {
    public CourseAlreadyPurchasedException(String message) {
        super(message);
    }
}
