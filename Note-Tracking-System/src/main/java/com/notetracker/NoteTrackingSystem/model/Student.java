package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentID;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "surname", nullable = false, length = 100)
    private String surname;
    @Column(name = "grade", nullable = false)
    private float grade;
    @Column(name = "averageGrade", nullable = false)
    private float averageGrade;
    @OneToMany
    @JoinColumn(name = "courseID")
    private Course courseID;

    public long getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getGrade() {
        return grade;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public Course getCourseName() {
        return courseID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourseID(Course courseID) {
        this.courseID= courseID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(surname, other.surname);
    }

    public Course getCourseID() {
        return courseID;
    }
}
