package com.example.demo.Repository;

import com.example.demo.Model.Student;
import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);
    Student findStudentByName(String name);
    List<Student> findAllByMajor(String major);
    List<Student> findByAgeGreaterThanEqual(Integer age);

}