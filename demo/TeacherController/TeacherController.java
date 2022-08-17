package com.example.demo.TeacherController;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;




import com.example.demo.Model.Teacher;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@Repository
@RestController
public class TeacherController {

        private final TeacherSer teacherSer;

        @GetMapping
        public ResponseEntity<List> getTeacher(){
            List<Teacher> teachers=teacherService.getTeacher();
            return ResponseEntity.status(200).body(teachers);
        }
        @PostMapping
        public ResponseEntity setTeacher(@RequestBody @Valid Teacher teacher){
            teacherSer.addTeacher(teacher);                                                                                                                                                               7(teacher);
            return ResponseEntity.status(201).body(new ApiResponse("New teacher added !",201));
        }
        @PutMapping("/{id}")
        public ResponseEntity putTeacher(@RequestBody @Valid Teacher teacher,@PathVariable Integer id){

            teacherSer.putTeacher(id,teacher);
            return ResponseEntity.status(201).body(new ApiResponse("New teacher updated !",201));

        }
        @DeleteMapping("/{id}")
        public ResponseEntity deleteTeacher(@PathVariable @Valid Integer id){
            teacherSer.deleteTeacher(id);
            return ResponseEntity.status(201).body(new Api("New teacher deleted !",201));

        }

        @GetMapping("/search/{id}")
        public ResponseEntity getTeacherByID(@PathVariable @Valid Integer id){
            Teacher teacher=teacherSer.findTeacherById(id);
            return ResponseEntity.status(200).body(teacher);
        }
        @GetMapping("/salary")
        public ResponseEntity getTeachersBySalary(@RequestBody Integer salary){
            List<Teacher> teachers= TeacherController.getTeacherBySalary(salary);
            return ResponseEntity.status(200).body(teachers);
        }


}
