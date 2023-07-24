package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "grade", nullable = false)
    private float grade;

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public float getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return student.getName() +
                " " + student.getSurname() +
                "\nId:" + student +
                "\nCourse:" + course +
                "\nGrade:" + grade;
    }
}
