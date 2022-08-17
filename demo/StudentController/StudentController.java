package com.example.demo.StudentController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@Repository
public class StudentController {


        private final StudentController studentService;


        @PostMapping
        public ResponseEntity setStudent(@RequestBody @Valid Student student){
            studentService.addStudent(student);
            return ResponseEntity.status(201).body(new Api("New student added !",201));
        }


    @PutMapping("/{id}")
        public ResponseEntity putStudent(@RequestBody @Valid StudentController student,@PathVariable Integer id){
            studentService.putStudent(id,student);
            return ResponseEntity.status(201).body(new Api("New student updated !",201));

        }
        @DeleteMapping("/{id}")
        public ResponseEntity deleteStudent(@PathVariable @Valid Integer id){
            studentService.deleteStudent(id);
            return ResponseEntity.status(201).body(new Api("New student deleted !",201));

        }
        // get by Student by id
        @GetMapping("/id/{id}")
        public ResponseEntity getStudentByID(@PathVariable @Valid Integer id){
            Student.student=studentService.getStudentById(id);
            return ResponseEntity.status(200).body(student);
        }



    @GetMapping("/name/{name}")
        public ResponseEntity getStudentByName(@PathVariable @Valid String name){
            Student student=studentService.findStudentByName(name);
            return ResponseEntity.status(200).body(student);
        }
        @GetMapping("major/{major}")
        public ResponseEntity getStudentsByMajor(@PathVariable @Valid String major){
            Student student= (Student) StudentService.getStudentsByMajor(major);
            return ResponseEntity.status(200).body(student);

        }
        @GetMapping("/age")
        public ResponseEntity<List> getStudentsByAge(@RequestBody Integer age){
            List<List> students= StudentService.getStudentsByAge(age);
            return ResponseEntity.status(200).body(students);
        }


    }

