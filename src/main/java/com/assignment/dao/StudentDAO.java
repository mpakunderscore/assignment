package com.assignment.dao;

import com.assignment.model.Student;

import java.util.List;

public interface StudentDAO {

	public void save(Student p);

	public void delete(Student p);

	public Student get(int id);
	
	public List list();
}
