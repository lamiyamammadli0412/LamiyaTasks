package org.example.service;

import org.example.exception.*;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final List<Course> courses;

    public CourseServiceImpl() {

        courses = new ArrayList<>();

        courses.add(new Course(1, "Java Core", 100, 5));
        courses.add(new Course(2, "Python", 80, 3));
        courses.add(new Course(3, "SQL", 60, 4));
        courses.add(new Course(4, "HTML & CSS", 50, 2));
    }

    @Override
    public void showCourses() {

        System.out.println("\n--- COURSES ---");

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Override
    public void buyCourse(User user, int courseId) {

        Course selectedCourse = null;

        for (Course course : courses) {

            if (course.getId() == courseId) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse == null) {
            System.out.println("Course not found!");
            return;
        }

        if (selectedCourse.getQuota() <= 0) {
            throw new CourseQuotaExceededException(
                    "There are no available places for this course!"
            );
        }

        if (user.getMyCourses().contains(selectedCourse)) {
            throw new CourseAlreadyPurchasedException(
                    "You have already purchased this course!"
            );
        }

        if (selectedCourse.getPrice() > user.getBalance()) {
            throw new BalanceNotEnoughException(
                    "Balance not enough!"
            );
        }

        user.pay(selectedCourse.getPrice());

        selectedCourse.decreaseQuota();

        user.addCourse(selectedCourse);

        System.out.println("The course was successfully purchased!");
    }

    @Override
    public void showMyCourses(User user) {

        System.out.println("\n--- MY COURSES ---");

        if (user.getMyCourses().isEmpty()) {
            System.out.println(
                    "You haven't taken any courses yet."
            );
            return;
        }

        for (Course course : user.getMyCourses()) {
            System.out.println(course.getName());
        }
    }
}