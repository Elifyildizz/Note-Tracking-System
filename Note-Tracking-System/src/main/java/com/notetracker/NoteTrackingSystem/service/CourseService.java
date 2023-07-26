package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Course;
import com.notetracker.NoteTrackingSystem.model.Student;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);

    String deleteCourse(long courseID);

    Course getCourseById(long courseID);

    List<Course> getAllCourse();

    List<Student> getPassedStudentsByCourseId(long courseId);

    List<Student> getFailedStudentsByCourseId(long courseId);

    float getCourseAverageGrade(long courseId);
}
