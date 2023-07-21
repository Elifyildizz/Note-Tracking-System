package com.notetracker.NoteTrackingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
}
