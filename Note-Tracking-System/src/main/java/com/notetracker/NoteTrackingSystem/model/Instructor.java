package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    private long instructor_id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;
    //id olarak değiştir patlaması
    @OneToMany
    @JoinColumn(name = "course_id")
    private Course course_id;

    public long getInstructor_id() {
        return instructor_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Course getCourse_id() {
        return course_id;
    }

    public void setInstructor_id(long instructor_id) {
        this.instructor_id = instructor_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        Instructor other = (Instructor) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(surname, other.surname);
    }
}
