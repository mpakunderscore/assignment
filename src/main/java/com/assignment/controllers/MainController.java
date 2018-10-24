package com.assignment.controllers;

import com.assignment.Application;
import com.assignment.dao.*;
import com.assignment.model.*;
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

    @RequestMapping("/teacher/get")
    public String getTeacher(@RequestParam(value="id", defaultValue="") int id) {

        TeacherDAO teacherDAO = Application.context.getBean(TeacherDAO.class);
        Teacher teacher = teacherDAO.get(id);

        return teacher.toString();
    }

    @RequestMapping("/teachers")
    public String getTeachersList() {

        TeacherDAO teacherDAO = Application.context.getBean(TeacherDAO.class);
        List<Teacher> teachers = teacherDAO.list();


        //TODO
        String listString = "";
        for (Teacher s : teachers) {
            listString += s.toString() + "\t";
        }

//        System.out.println(listString);

        return listString;
    }

    @RequestMapping("/subject/get")
    public Subject getSubject(@RequestParam(value="id", defaultValue="") int id) {

        SubjectDAO subjectDAO = Application.context.getBean(SubjectDAO.class);
        Subject subject = subjectDAO.get(id);

        return subject;
    }

    @RequestMapping("/subjects")
    public List<Subject> getSubjectsList() {

        SubjectDAO subjectDAO = Application.context.getBean(SubjectDAO.class);
        List<Subject> subjects = subjectDAO.list();

        return subjects;
    }

    @RequestMapping("/specialty/get")
    public Specialty getSpecialty(@RequestParam(value="id", defaultValue="") int id) {

        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        Specialty subject = specialtyDAO.get(id);

        return subject;
    }

    @RequestMapping("/specialty")
    public List<Specialty> getSpecialtyList() {

        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        List<Specialty> specialty = specialtyDAO.list();

        return specialty;
    }

    @RequestMapping("/group/get")
    public Group getGroup(@RequestParam(value="id", defaultValue="") int id) {

        GroupDAO groupDAO = Application.context.getBean(GroupDAO.class);
        Group group = groupDAO.get(id);

        return group;
    }

    @RequestMapping("/groups")
    public List<Group> getGroupsList() {

        GroupDAO groupDAO = Application.context.getBean(GroupDAO.class);
        List<Group> groups = groupDAO.list();

        return groups;
    }
}
