package com.example.demo.Service;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.exception.MessageException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void putStudent(Integer id, Student student) {
        Student oldStudent=studentRepository.getById(id);
        oldStudent.setAge(student.getAge());
        oldStudent.setName(student.getName());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        Student student=studentRepository.getById(id);
        studentRepository.delete(student);
    }
    public Student getStudentById(Integer id){
        Student student= studentRepository.findStudentById(id);
        if(student==null){
            throw new MessageException("Wrong student ID!");
        }
        return student;
    }
    public Student findStudentByName(String name){
        Student student= studentRepository.findStudentByName(name);
        if(student==null){
            throw new MessageException("Wrong student ID!");
        }
        return student;
    }
    public List<Student> getStudentsByMajor(String major) {
        List<Student> students=studentRepository.findAllByMajor(major);
        if (students.isEmpty()){
            throw new MessageException("Wrong , try another major!");
        }
        return students;
    }
    public List<Student> getStudentsByAge(Integer age) {
        List<Student> students=studentRepository.findByAgeGreaterThanEqual(age);
        if (students.isEmpty()){
            throw new MessageException("There is no students by this age or grater than!");
        }
        return students;
    }



}