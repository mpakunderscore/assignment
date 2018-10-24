package com.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="SUBJECT")
public class Subject {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String title;

    public Subject() {
    }

    public Subject(String title) {
        this.title = title;
    }
}