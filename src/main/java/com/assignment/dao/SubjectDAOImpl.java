package com.assignment.dao;

import com.assignment.Application;
import com.assignment.model.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Subject s) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();
    }

    public void delete(Subject s) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
        session.close();
    }

    public Subject get(int id) {
        Session session = this.sessionFactory.openSession();
        Subject subject = session.get(Subject.class, id);
        session.close();

        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        subject.setSpecialty(specialtyDAO.get(subject.getSpecialty().getId()));

        return subject;
    }

    public List<Subject> list() {
        Session session = this.sessionFactory.openSession();
        List<Subject> list = session.createQuery("from Subject").list();
        session.close();

        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        for (Subject s : list) {
            s.setSpecialty(specialtyDAO.get(s.getSpecialty().getId()));
        }


        return list;
    }
}
