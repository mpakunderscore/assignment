package com.assignment.dao;

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
        Teacher Teacher = session.get(Teacher.class, id);
        session.close();
        return Teacher;
    }

    public List<Teacher> list() {
        Session session = this.sessionFactory.openSession();
        List<Teacher> list = session.createQuery("from Teacher").list();
        session.close();
        return list;
    }
}
