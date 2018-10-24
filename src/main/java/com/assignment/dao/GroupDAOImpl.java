package com.assignment.dao;

import com.assignment.Application;
import com.assignment.model.Group;
import com.assignment.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GroupDAOImpl implements GroupDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Group g) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(g);
        tx.commit();
        session.close();
    }

    public void delete(Group g) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(g);
        tx.commit();
        session.close();
    }

    public Group get(int id) {
        Session session = this.sessionFactory.openSession();
        Group group = session.get(Group.class, id);
        session.close();

        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        group.setSpecialty(specialtyDAO.get(group.getSpecialty().getId()));

        SubjectDAO subjectDAO = Application.context.getBean(SubjectDAO.class);
        group.setSubject(subjectDAO.get(group.getSubject().getId()));

        TeacherDAO teacherDAO = Application.context.getBean(TeacherDAO.class);
        group.setTeacher(teacherDAO.get(group.getTeacher().getId()));

        StudentDAO studentDAO = Application.context.getBean(StudentDAO.class);
        for (Student s : group.getStudents()) {
            s = studentDAO.get(s.getId());
        }

        return group;
    }

    public List<Group> list() {
        Session session = this.sessionFactory.openSession();
        List<Group> list = session.createQuery("from Group").list();
        session.close();
        return list;
    }

    //FULL DATA LIST
    public List<Group> listFull() {
        Session session = this.sessionFactory.openSession();
        List<Group> list = session.createQuery("from Group").list();
        session.close();
        return list;
    }
}
