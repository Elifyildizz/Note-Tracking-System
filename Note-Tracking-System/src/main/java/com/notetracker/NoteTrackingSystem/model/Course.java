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

}
