package com.assignment.dao;

import com.assignment.Application;
import com.assignment.model.Group;
import com.assignment.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
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

        //TODO
//        GroupDAO groupDAO = Application.context.getBean(GroupDAO.class);
        student.setGroups(new HashSet<Group>());

        return student;
    }

	public List<Student> list() {
		Session session = this.sessionFactory.openSession();
		List<Student> list = session.createQuery("from Student").list();
		session.close();

		//TODO
//        GroupDAO groupDAO = Application.context.getBean(GroupDAO.class);
		for (Student s : list) {
		    s.setGroups(new HashSet<Group>());
        }

        return list;
	}
}
