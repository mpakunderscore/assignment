package com.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="SPECIALTY")
public class Specialty {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    @OneToMany(mappedBy="SPECIALTY")
//    private Set<Teacher> teachers;

    public Specialty() {
    }

    public Specialty(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
