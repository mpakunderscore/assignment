package com.assignment.dao;

import com.assignment.model.Subject;

import java.util.List;

public interface SubjectDAO {

    public void save(Subject p);

    public void delete(Subject p);

    public Subject get(int id);

    public List list();
}
