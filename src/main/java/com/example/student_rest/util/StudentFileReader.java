package com.example.student_rest.util;

import com.example.student_rest.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentFileReader {

    public static List<Student> readStudents(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            boolean isFirstLine = true; // Skip header
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Long id = Long.parseLong(parts[0].trim());
                    String name = parts[1].trim();
                    double gpa = Double.parseDouble(parts[2].trim());
                    String email = parts[3].trim();
                    String gender = parts[4].trim();

                    students.add(new Student(id, name, gpa, email, gender));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}

