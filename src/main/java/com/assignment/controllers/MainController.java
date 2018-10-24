package com.assignment.controllers;

import com.assignment.Application;
import com.assignment.dao.StudentDAO;
import com.assignment.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/student/get?id=1
// http://localhost:8080/students

@RestController
public class MainController {

    @RequestMapping("/student/get")
    public Student getStudent(@RequestParam(value="id", defaultValue="") int id) {

        StudentDAO studentDAO = Application.context.getBean(StudentDAO.class);
        Student student = studentDAO.get(id);

        return student;
    }

    @RequestMapping("/students")
    public List<Student> getStudentsList() {

        StudentDAO studentDAO = Application.context.getBean(StudentDAO.class);
        List<Student> students = studentDAO.list();

        return students;
    }
}
