package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

/*
create table student
(
    student_id    int primary key,
    name          varchar(100),
    surname       varchar(100),
    average_grade float
);
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    private long student_id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "average_grade", nullable = false)
    private float average_grade;

    public long getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getAverage_grade() {
        return average_grade;
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

    public void setAverage_grade(float average_grade) {
        this.average_grade = average_grade;
    }
}
