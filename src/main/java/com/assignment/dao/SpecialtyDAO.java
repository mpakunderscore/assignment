package com.assignment.dao;

import com.assignment.model.Specialty;

import java.util.List;

public interface SpecialtyDAO {

    public void save(Specialty p);

    public void delete(Specialty p);

    public Specialty get(int id);

    public List list();
}
