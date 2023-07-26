package com.notetracker.NoteTrackingSystem.controller;

import com.notetracker.NoteTrackingSystem.model.Course;
import com.notetracker.NoteTrackingSystem.model.Student;
import com.notetracker.NoteTrackingSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/saveCourse")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/delete/{courseID}")
    public String deleteStudents(@PathVariable(value = "courseID") long courseID) {
        return courseService.deleteCourse(courseID);
    }

    @GetMapping("/getCourseById/{courseID}")
    public Course getCourseById(@PathVariable long courseID) {
        return courseService.getCourseById((courseID));
    }

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/getPassedStudents/{courseID}")
    public List<Student> getPassedStudentsByCourseId(@PathVariable long courseID) {
        return courseService.getPassedStudentsByCourseId(courseID);
    }

    @GetMapping("/getFailedStudents/{courseID}")
    public List<Student> getFailedStudentsByCourseId(@PathVariable long courseID) {
        return courseService.getFailedStudentsByCourseId(courseID);
    }

    @GetMapping("/courseAverageGrade/{courseID}")
    public float getCourseAverageGrade(@PathVariable long courseID) {
        return courseService.getCourseAverageGrade(courseID);
    }
}
