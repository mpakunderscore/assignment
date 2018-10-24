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
        Specialty specialtyOne = new Specialty("Algebra");
        specialtyDAO.save(specialtyOne);
        Specialty specialtyTwo = new Specialty("Physics");
        specialtyDAO.save(specialtyTwo);

        //Teacher
        TeacherDAO teacherDAO = context.getBean(TeacherDAO.class);
        Teacher teacherOne = new Teacher("Lucky", "Teacher1", specialtyOne);
        teacherDAO.save(teacherOne);
        Teacher teacherTwo = new Teacher("Some", "Teacher2", specialtyTwo);
        teacherDAO.save(teacherTwo);

        System.out.println(teacherDAO.get(teacherOne.getId()));


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
        Subject subjectOne = new Subject(specialtyOne, "Algebra I");
        subjectDAO.save(subjectOne);
        Subject subjectTwo = new Subject(specialtyOne, "Algebra II");
        subjectDAO.save(subjectTwo);


        //Group
        GroupDAO groupDAO = context.getBean(GroupDAO.class);
        Group group = new Group(teacherOne, subjectOne);
        group.addStudent(studentOne);
        group.addStudent(studentTwo);
//        groupDAO.save(group);


        SpringApplication.run(Application.class, args);
    }
}