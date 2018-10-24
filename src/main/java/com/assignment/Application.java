package com.assignment;

import com.assignment.dao.*;
import com.assignment.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//        teacherDAO.get(teacherOne.getId());
//        System.out.println();


        //Student
        StudentDAO studentDAO = context.getBean(StudentDAO.class);
        Student studentOne = new Student("Mary", "Cirks");
        studentDAO.save(studentOne);
        Student studentTwo = new Student("Vik", "Budharja");
        studentDAO.save(studentTwo);
        Student studentThree = new Student("Catherine", "Brown");
        studentDAO.save(studentThree);

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

        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(studentOne);
        studentSet.add(studentTwo);
        studentSet.add(studentThree);

        group.setStudents(studentSet);
        groupDAO.save(group);

        System.out.println(groupDAO.get(1));


        SpringApplication.run(Application.class, args);
    }
}