package com.assignment;

import com.assignment.dao.StudentDAO;
import com.assignment.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    public static void main(String[] args) {

        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        studentDAO.save(new Student("Mary", "Cirks"));
        studentDAO.save(new Student("Vik", "Budharja"));
        studentDAO.save(new Student("Catherine", "Brown"));

        Student studentDelete = new Student("Unlucky", "Dude");
        studentDAO.save(studentDelete);

        System.out.println(studentDAO.get(studentDelete.getId()));

        studentDAO.delete(studentDelete);

        List<Student> list = studentDAO.list();
        for (Student s : list) {
            System.out.println(s);
        }

        SpringApplication.run(Application.class, args);
    }
}