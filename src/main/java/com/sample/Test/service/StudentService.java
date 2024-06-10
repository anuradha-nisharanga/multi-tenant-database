package com.sample.Test.service;

import com.sample.Test.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudent();

    void addStudent(Student student);
}
