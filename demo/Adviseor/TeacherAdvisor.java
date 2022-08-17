package com.example.demo.Adviseor;

import com.example.demo.exception.MessageException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
@RestControllerAdvice
public class TeacherAdvisor {
    @ExceptionHandler(value = MessageException.class)
    public ResponseEntity<MessageException> apiException(MessageException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<MessageException> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<MessageException> EntityNotFoundException(EntityNotFoundException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<MessageException> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }


}


