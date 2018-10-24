package com.assignment.dao;

import com.assignment.model.Group;

import java.util.List;

public interface GroupDAO {

    public void save(Group p);

    public void delete(Group p);

    public Group get(int id);

    public List list();
}
