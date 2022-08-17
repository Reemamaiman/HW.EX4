package com.example.demo.Service;

import com.example.demo.Model.Teacher;
import com.example.demo.Repository.TeacherRepository;
import com.example.demo.Service.TeacherService;

import com.example.demo.exception.MessageException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getStudent() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void putTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher=teacherRepository.getById(id);
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);

    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.getById(id);
        teacherRepository.delete(teacher);
    }
    public Teacher findTeacherById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new MessageException("Wrong teacher ID!");
        }
        return teacher;
    }
    public List<Teacher> getTeachersBySalary(Integer salary) {
        List<Teacher> teachers= teacherRepository.findBySalaryGreaterThanEqual(salary);
        if (teachers.isEmpty()){
            throw new MessageException("There is no teachers by this salary or grater than!");
        }
        return teachers;
    }



}