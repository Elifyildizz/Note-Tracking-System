package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Course;
import com.notetracker.NoteTrackingSystem.model.Student;
import com.notetracker.NoteTrackingSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        List<Student> newRecordStudent = studentRepository.findAll();

        boolean isSame = newRecordStudent.stream()
                .anyMatch(a -> a.getName().equals(student.getName()) && student.getSurname().equals(student.getSurname()));
        if (isSame) {
            throw new RuntimeException("This student has been already enrolled.");
        }
        this.studentRepository.save(student);
        return student;
    }

    @Override
    public String deleteStudent(long studentID) {
        Optional<Student> optionalStudent = studentRepository.findById(studentID);
        if (optionalStudent.isPresent()) {
            this.studentRepository.deleteById(optionalStudent.get().getStudentID());
        } else {
            throw new RuntimeException(studentID + " Is not found.");
        }
        return null;
    }

    @Override
    public Student getStudentById(long studentID) {
        Optional<Student> optionalStudent = studentRepository.findById(studentID);
        Student student;
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        } else {
            throw new RuntimeException(studentID + " Is not found.");
        }
        return student;
    }

    @Override
    public String updateStudent(Student student) {
        long studentId = student.getStudentID();
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        optionalStudent.ifPresent(existingStudent -> {
            existingStudent.setName(student.getName());
            existingStudent.setSurname(student.getSurname());
            existingStudent.setGrade(student.getGrade());
            existingStudent.setAverageGrade(student.getAverageGrade());
            studentRepository.save(existingStudent);
        });
        return "Student updated successfully.";
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public float calculateAverageNote(long studentID) {
        Optional<Student> optionalStudent = studentRepository.findById(studentID);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<Float> grades = new ArrayList<>();
            grades.add(student.getGrade());

            Course course = student.getCourseID();
            List<Student> studentsEnrolledCourse = course.getStudents();
            for (Student s : studentsEnrolledCourse) {
                grades.add(s.getGrade());
            }
            float sum = 0;
            for (Float grade : grades) {
                sum = sum + grade;
            }
            return sum / grades.size();
        } else {
            throw new RuntimeException(studentID + " Is not found.");
        }
    }
}