package com.assignment;

import com.assignment.dao.*;
import com.assignment.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    public static void main(String[] args) {

        //Specialty
        SpecialtyDAO specialtyDAO = context.getBean(SpecialtyDAO.class);
        Specialty specialty = new Specialty("Algebra");
        specialtyDAO.save(specialty);

        //Teacher
        TeacherDAO teacherDAO = context.getBean(TeacherDAO.class);
        Teacher teacher = new Teacher("Lucky", "Teacher", specialty);
        teacherDAO.save(teacher);
        System.out.println(teacherDAO.get(teacher.getId()));


        //Student
        StudentDAO studentDAO = context.getBean(StudentDAO.class);
        Student studentOne = new Student("Mary", "Cirks");
        studentDAO.save(studentOne);
        Student studentTwo = new Student("Vik", "Budharja");
        studentDAO.save(studentTwo);
        studentDAO.save(new Student("Catherine", "Brown"));

        Student studentDelete = new Student("Unlucky", "Dude");
        studentDAO.save(studentDelete);

        System.out.println(studentDAO.get(studentDelete.getId()));

        studentDAO.delete(studentDelete);

        List<Student> list = studentDAO.list();
        for (Student s : list) {
            System.out.println(s);
        }

        //Subject
        SubjectDAO subjectDAO = context.getBean(SubjectDAO.class);
        Subject subjectOne = new Subject(specialty, "Algebra I");
        subjectDAO.save(subjectOne);
        Subject subjectTwo = new Subject(specialty, "Algebra II");
        subjectDAO.save(subjectTwo);


        //Group
        GroupDAO groupDAO = context.getBean(GroupDAO.class);
        Group group = new Group(teacher, subjectOne);
        group.addStudent(studentOne);
        group.addStudent(studentTwo);
        groupDAO.save(group);


        SpringApplication.run(Application.class, args);
    }
}