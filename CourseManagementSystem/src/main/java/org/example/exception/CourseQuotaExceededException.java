package org.example.exception;

public class CourseQuotaExceededException extends RuntimeException {

    public CourseQuotaExceededException(String message) {
        super(message);
    }
}