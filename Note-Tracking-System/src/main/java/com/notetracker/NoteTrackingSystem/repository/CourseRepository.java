package com.notetracker.NoteTrackingSystem.repository;

import com.notetracker.NoteTrackingSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
