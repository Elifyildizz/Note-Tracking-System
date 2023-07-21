package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

/*
create table enrollment
(
    student_id int references student (student_id),
    course_id  int references course (course_id),
    grade      float
);
 */
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

    private float grade;

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public float getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}