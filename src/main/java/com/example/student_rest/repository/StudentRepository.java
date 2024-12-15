package com.example.student_rest.repository;

import com.example.student_rest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByGender(String gender);

    List<Student> findByNameIgnoreCase(String name);

    List<Student> findByGpaBetweenAndGender(double minGpa, double maxGpa, String gender);
}
