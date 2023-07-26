package com.notetracker.NoteTrackingSystem.repository;

import com.notetracker.NoteTrackingSystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
