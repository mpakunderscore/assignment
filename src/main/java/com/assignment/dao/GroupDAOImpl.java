package com.assignment.dao;

import com.assignment.model.Group;
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
        Group Group = session.get(Group.class, id);
        session.close();
        return Group;
    }

    public List<Group> list() {
        Session session = this.sessionFactory.openSession();
        List<Group> list = session.createQuery("from Group").list();
        session.close();
        return list;
    }
}
