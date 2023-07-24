package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "surname", nullable = false, length = 100)
    private String surname;
    @Column(name = "grade", nullable = false)
    private float grade;
    @Column(name = "average_grade", nullable = false)
    private float average_grade;
    @OneToMany
    @JoinColumn(name = "course_id")
    private Course course_id;

    public long getStudent_id() {
        return student_id;
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

    public float getAverage_grade() {
        return average_grade;
    }

    public Course getCourse_name() {
        return course_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
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

    public void setAverage_grade(float average_grade) {
        this.average_grade = average_grade;
    }

    public void setCourse_id(Course course_id) {
        this.course_id = course_id;
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
}
