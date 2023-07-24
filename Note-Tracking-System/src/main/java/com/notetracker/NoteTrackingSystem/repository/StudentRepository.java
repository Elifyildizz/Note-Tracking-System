package com.notetracker.NoteTrackingSystem.repository;

import com.notetracker.NoteTrackingSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}