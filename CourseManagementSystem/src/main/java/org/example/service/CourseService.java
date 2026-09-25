package org.example.service;

import org.example.model.Course;
import org.example.model.User;


public interface CourseService {

        void showCourses();

        void buyCourse(User user, int courseId);

        void showMyCourses(User user);

}