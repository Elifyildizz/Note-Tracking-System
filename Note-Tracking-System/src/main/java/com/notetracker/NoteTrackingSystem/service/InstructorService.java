package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Instructor;

public interface InstructorService {
    Instructor saveInstructor(Instructor instructor);

    String deleteInstructor(long instructorID);

    Instructor getInstructorById(long instructorID);

    String updateInstructor(Instructor instructor);
}
