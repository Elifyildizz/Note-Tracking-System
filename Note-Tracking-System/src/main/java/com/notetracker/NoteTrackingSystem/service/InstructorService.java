package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Instructor;

public interface InstructorService {
    /*
    Bir dersi bir çok öğrenci alacak.
    Bir öğretmen birden çok ders alabilecek şekilde bir yapı olacak.
    her 3 resource içinde crud işlemleri yapılacak ve ayrıca bir dersi alan tüm öğrenciler.
    bir dersten geçen ve kalan öğrenciler.
    bir dersin ortalaması.
    bir öğrencinin ortalama notu şeklinde hesaplamalar yapan api ler yazılacak
     */
    Instructor saveInstructor(Instructor instructor);
    String deleteInstructor(long instructorID);
    Instructor getInstructorById(long instructorID);
    String updateInstructor(Instructor instructor);
}
