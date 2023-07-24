package com.notetracker.NoteTrackingSystem.repository;

import com.notetracker.NoteTrackingSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
