package com.example.student_rest.service;

import com.example.student_rest.model.Student;
import com.example.student_rest.util.StudentFileReader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final List<Student> students;

    public StudentService() {
        this.students = StudentFileReader.readStudents("src/main/resources/student.txt");
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> searchByName(String name) {
        return students.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Student> findByGpaAndGender(double minGpa, double maxGpa, String gender) {
        return students.stream()
                .filter(student -> student.getGpa() >= minGpa && student.getGpa() <= maxGpa)
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }
}
