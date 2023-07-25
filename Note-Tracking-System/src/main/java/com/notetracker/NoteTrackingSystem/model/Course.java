package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "course")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseID")
    private int courseID;
    @Column(name = "courseName", nullable = false)
    private String courseName;
    @ManyToMany
    @JoinColumn(name = "studentID")
    private Student studentID;
    @ManyToMany
    @JoinColumn(name = "instructorID")
    private Instructor instructorID;

    @ElementCollection
    @CollectionTable(name = "courseStudentGrades", joinColumns = @JoinColumn(name = "courseID"))
    @MapKeyJoinColumn(name = "studentID")
    @Column(name = "grade")
    private Map<Student, Float> studentGrades;
    private List<Student> students;

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Student getStudentID() {
        return studentID;
    }

    public Instructor getInstructorID() {
        return instructorID;
    }

    public Map<Student, Float> getStudentGrades() {
        return studentGrades;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    public void setInstructorID(Instructor instructorID) {
        this.instructorID = instructorID;
    }

    public void setStudentGrades(Map<Student, Float> studentGrades) {
        this.studentGrades = studentGrades;
    }

    @Override
    public String toString() {
        return courseName +
                " " + courseID +
                "\nGiven By" + instructorID+
                "\nGrades:" + studentGrades;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}