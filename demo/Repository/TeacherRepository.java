package com.example.demo.Repository;

import com.example.demo.Model.Student;
import com.example.demo.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
    List<Teacher> findBySalaryGreaterThanEqual(Integer salary);


}