package org.example.exception;

public class ExceptionHandler {
    public static Response handleBalanceNotEnough(
            BalanceNotEnoughException e
    ) {
        return new Response(
                "Balance not enough: " + e.getMessage()
        );
    }

    public static Response handleCourseQuotaExceeded(
            CourseQuotaExceededException e
    ) {
        return new Response(
                "Course quota exceeded: " + e.getMessage()
        );
    }

    public static Response handleCourseAlreadyPurchased(
            CourseAlreadyPurchasedException e
    ) {
        return new Response(
                "Course already purchased: " + e.getMessage()
        );
    }

    public static Response handleInvalidUserData(
            InvalidUserDataException e
    ) {
        return new Response(
                "Invalid user data: " + e.getMessage()
        );
    }
}
