package com.example.student_rest.util;

import com.example.student_rest.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentFileReader {
    public List<Student> readStudentsFromFile() throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/student.txt")))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != 5) {
                    throw new IllegalArgumentException("Invalid data format");
                }
                Student student = new Student();
                student.setId(Long.parseLong(values[0]));
                student.setFirstName(values[1]);
                student.setGpa(Double.parseDouble(values[2]));
                student.setEmail(values[3]);
                student.setGender(values[4]);
                students.add(student);
            }
        }
        return students;
    }
}