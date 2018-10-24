package com.assignment.model;

import com.assignment.Application;
import com.assignment.dao.SpecialtyDAO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="TEACHER")
public class Teacher {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPECIALTY_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Specialty specialty;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Specialty getSpecialty() {

        //TODO
        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        specialty = specialtyDAO.get(specialty.getId());

        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {

        //TODO
        SpecialtyDAO specialtyDAO = Application.context.getBean(SpecialtyDAO.class);
        specialty = specialtyDAO.get(specialty.getId());

        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty=" + specialty.toString() +
                '}';
    }
}
