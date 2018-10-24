package com.assignment;

import com.assignment.dao.SpecialtyDAO;
import com.assignment.dao.StudentDAO;
import com.assignment.dao.SubjectDAO;
import com.assignment.dao.TeacherDAO;
import com.assignment.model.Specialty;
import com.assignment.model.Student;
import com.assignment.model.Subject;
import com.assignment.model.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    public static void main(String[] args) {

        SpecialtyDAO specialtyDAO = context.getBean(SpecialtyDAO.class);
        Specialty specialty = new Specialty("Algebra");
        specialtyDAO.save(specialty);

        SubjectDAO subjectDAO = context.getBean(SubjectDAO.class);
        Subject subjectOne = new Subject("Algebra I");
        subjectDAO.save(subjectOne);
        Subject subjectTwo = new Subject("Algebra II");
        subjectDAO.save(subjectTwo);

        TeacherDAO teacherDAO = context.getBean(TeacherDAO.class);
        Teacher teacher = new Teacher("Lucky", "Man", specialty);
        teacherDAO.save(teacher);

        System.out.println(teacherDAO.get(teacher.getId()));

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