package com.notetracker.NoteTrackingSystem.service;

import com.notetracker.NoteTrackingSystem.model.Student;

import java.util.List;

public interface StudentService {
    /*
    Bir dersi bir çok öğrenci alacak.
    Bir öğretmen birden çok ders alabilecek şekilde bir yapı olacak.
    her 3 resource içinde crud işlemleri yapılacak ve ayrıca bir dersi alan tüm öğrenciler.
    bir dersten geçen ve kalan öğrenciler.
    bir dersin ortalaması.
    bir öğrencinin ortalama notu şeklinde hesaplamalar yapan api ler yazılacak
     */
    Student saveStudent(Student student);
    String deleteStudent(long student_id);
    Student getStudentById(long student_id);
    String updateStudent(Student student);
    List<Student> getAllStudents();
    float calculateAverageNote(long student_id);
}
