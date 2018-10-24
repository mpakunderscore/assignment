package com.assignment.dao;

import com.assignment.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(Student s) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(s);
		tx.commit();
		session.close();
	}

	public void delete(Student s) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(s);
		tx.commit();
		session.close();
	}

    public Student get(int id) {
        Session session = this.sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

	public List<Student> list() {
		Session session = this.sessionFactory.openSession();
		List<Student> personList = session.createQuery("from Student").list();
		session.close();
		return personList;
	}

}
