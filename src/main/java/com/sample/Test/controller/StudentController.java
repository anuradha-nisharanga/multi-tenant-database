package com.sample.Test.controller;

import com.sample.Test.model.Student;
import com.sample.Test.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
@CrossOrigin(origins = "*")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping
    @ResponseBody
    public List<Student> getStudent() {
        log.info("Calling Student Controller");
        return studentService.getStudent();
    }
}
