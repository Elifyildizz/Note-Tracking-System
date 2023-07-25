package com.notetracker.NoteTrackingSystem.controller;

import com.notetracker.NoteTrackingSystem.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    public List<Student> getName;


}
