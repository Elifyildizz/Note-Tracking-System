package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    private long instructor_id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    public long getInstructor_id() {
        return instructor_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
}
