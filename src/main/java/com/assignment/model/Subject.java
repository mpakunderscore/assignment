package com.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="SUBJECT")
public class Subject {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private Specialty specialty;

    private String title;

    public Subject() {
    }

    public Subject(Specialty specialty, String title) {
        this.specialty = specialty;
        this.title = title;
    }
}