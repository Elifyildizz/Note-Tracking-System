package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Course;
import com.notetracker.NoteTrackingSystem.model.Student;
import com.notetracker.NoteTrackingSystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        List<Course> newRecordCourse = courseRepository.findAll();
        boolean isSame = newRecordCourse.stream()
                .anyMatch(a -> a.getCourseName().equals(course.getCourseName()));
        if (isSame) {
            throw new RuntimeException("This course has been already enrolled.");
        }
        this.courseRepository.save(course);
        return course;
    }

    @Override
    public String deleteCourse(long courseID) {
        Optional<Course> optionalCourse = courseRepository.findById(courseID);
        if (optionalCourse.isPresent()) {
            this.courseRepository.deleteById(optionalCourse.get().getCourseID());
        } else {
            throw new RuntimeException(courseID + " Is not found.");
        }
        return null;
    }

    @Override
    public Course getCourseById(long courseID) {
        Optional<Course> optionalCourse = courseRepository.findById(courseID);
        Course course;
        if (optionalCourse.isPresent()) {
            course = optionalCourse.get();
        } else {
            throw new RuntimeException(courseID + " Is not found.");
        }
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Student> getPassedStudentsByCourseId(long courseID) {
        Optional<Course> optionalCourse = courseRepository.findById(courseID);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            List<Student> studentList = course.getStudents();

            List<Student> passedStudents = studentList.stream()
                    .filter(student -> student.getGrade() >= 50)
                    .collect(Collectors.toList());
            return passedStudents;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Student> getFailedStudentsByCourseId(long courseID) {
        Optional<Course> optionalCourse = courseRepository.findById(courseID);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            List<Student> studentList = course.getStudents();

            List<Student> failedStudents = studentList.stream()
                    .filter(student -> student.getGrade() < 50)
                    .collect(Collectors.toList());
            return failedStudents;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public float getCourseAverageGrade(long courseID) {
        Optional<Course> optionalCourse = courseRepository.findById(courseID);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            List<Student> students = course.getStudents();

            float sum = 0;
            int studentCount = students.size();
            for (Student student : students) {
                sum = sum + student.getGrade();
            }
            return sum / studentCount;
        } else {
            throw new RuntimeException(courseID + " Course is not found.");
        }
    }
}
