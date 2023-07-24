package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int course_id;
    @Column(name = "course_name", nullable = false)
    private String course_name;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor_id;

    @OneToMany(mappedBy = "course")
    private List<Course> courses;

    public int getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public Instructor getInstructor_id() {
        return instructor_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public void setInstructor_id(Instructor instructor_id) {
        this.instructor_id = instructor_id;
    }

    @Override
    public String toString() {
        return course_name +
                " " + course_id +
                "\nGiven By" + instructor_id +
                "\nOther Courses:" + courses;
    }
}
