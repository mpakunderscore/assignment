package com.assignment.dao;

import com.assignment.model.Teacher;

import java.util.List;

public interface TeacherDAO {

    public void save(Teacher p);

    public void delete(Teacher p);

    public Teacher get(int id);

    public List list();
}
