package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Instructor;
import com.notetracker.NoteTrackingSystem.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        List<Instructor> newRecordInstructor = instructorRepository.findAll();
        boolean isSame = newRecordInstructor.stream()
                .anyMatch(a -> a.getName().equals(instructor.getName()) && instructor.getSurname().equals(instructor.getSurname()));
        if (isSame) {
            throw new RuntimeException("This instructor has been already enrolled.");
        }
        this.instructorRepository.save(instructor);
        return instructor;
    }

    @Override
    public String deleteInstructor(long instructorID) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorID);
        if (optionalInstructor.isPresent()) {
            this.instructorRepository.deleteById(optionalInstructor.get().getInstructorID());
        } else {
            throw new RuntimeException(instructorID + " Is not found.");
        }
        return null;
    }

    @Override
    public Instructor getInstructorById(long instructorID) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorID);
        Instructor instructor;
        if (optionalInstructor.isPresent()) {
            instructor = optionalInstructor.get();
        } else {
            throw new RuntimeException(instructorID + " Is not found.");
        }
        return instructor;
    }

    @Override
    public String updateInstructor(Instructor instructor) {
        long instructorID = instructor.getInstructorID();
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorID);

        optionalInstructor.ifPresent(existingInstructor -> {
            existingInstructor.setName(instructor.getName());
            existingInstructor.setSurname((instructor.getSurname()));
            instructorRepository.save(existingInstructor);
        });
        return "Instructor updated successfully.";
    }
}