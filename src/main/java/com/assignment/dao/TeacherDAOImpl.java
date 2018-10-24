package com.assignment.dao;

import com.assignment.Application;
import com.assignment.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Teacher t) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(t);
        tx.commit();
        session.close();
    }

    public void delete(Teacher t) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(t);
        tx.commit();
        session.close();
    }

    public Teacher get(int id) {
        Session session = this.sessionFactory.openSession();
        Teacher teacher = session.get(Teacher.class, id);
        session.close();

        //TODO
        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        teacher.setSpecialty(specialtyDAO.get(teacher.getSpecialty().getId()));

        return teacher;
    }

    public List<Teacher> list() {
        Session session = this.sessionFactory.openSession();
        List<Teacher> list = session.createQuery("from Teacher").list();
        session.close();

        //TODO
        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        for (Teacher t : list) {
            t.setSpecialty(specialtyDAO.get(t.getSpecialty().getId()));
        }

        return list;
    }
}
