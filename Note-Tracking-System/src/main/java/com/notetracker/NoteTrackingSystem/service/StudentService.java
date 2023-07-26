package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    String deleteStudent(long studentID);

    Student getStudentById(long studentID);

    String updateStudent(Student student);

    List<Student> getAllStudents();

    float calculateAverageNote(long studentID);
}