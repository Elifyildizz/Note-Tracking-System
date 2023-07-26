package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long instructorID;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;
    @OneToMany
    @JoinColumn(name = "courseID")
    private Course courseID;
    public Instructor(){
        this.instructorID=instructorID;
        this.name=name;
        this.surname=surname;
        this.courseID=courseID;
    }

    public long getInstructorID() {
        return instructorID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Course getCourseID() {
        return courseID;
    }

    public void setInstructorID(long instructorID) {
        this.instructorID = instructorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
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
        Instructor other = (Instructor) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(surname, other.surname);
    }
}
