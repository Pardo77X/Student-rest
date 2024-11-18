package com.example.student_rest.controller;

import com.example.student_rest.model.Student;
import com.example.student_rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        List<Student> students = studentService.searchByName(name);
        if (students.isEmpty()) {
        }
        return students;
    }

    @GetMapping
    public List<Student> get;
}