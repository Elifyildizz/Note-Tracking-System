package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;
/*
create table course
(
    course_id     int primary key,
    course_name   varchar(100) not null,
    instructor_id int references instructor (instructor_id)
);
 */
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}