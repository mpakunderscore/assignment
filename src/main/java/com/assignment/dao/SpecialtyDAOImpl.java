package com.assignment.dao;

import com.assignment.model.Specialty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SpecialtyDAOImpl implements SpecialtyDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Specialty s) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();
    }

    public void delete(Specialty s) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
        session.close();
    }

    public Specialty get(int id) {
        Session session = this.sessionFactory.openSession();
        Specialty Specialty = session.get(Specialty.class, id);
        session.close();
        return Specialty;
    }

    public List<Specialty> list() {
        Session session = this.sessionFactory.openSession();
        List<Specialty> list = session.createQuery("from Specialty").list();
        session.close();
        return list;
    }
}
