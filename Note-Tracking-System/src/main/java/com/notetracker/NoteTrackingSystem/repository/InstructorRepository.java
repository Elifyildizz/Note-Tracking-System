package com.notetracker.NoteTrackingSystem.repository;

import com.notetracker.NoteTrackingSystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
