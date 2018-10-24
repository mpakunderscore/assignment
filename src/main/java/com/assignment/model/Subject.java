package com.assignment.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="SUBJECT")
public class Subject {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPECIALTY_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Specialty specialty;

    private String title;

    public Subject() {
    }

    public Subject(Specialty specialty, String title) {
        this.specialty = specialty;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", specialty=" + specialty +
                ", title='" + title + '\'' +
                '}';
    }
}