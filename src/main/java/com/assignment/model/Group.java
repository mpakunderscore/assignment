package com.assignment.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="GROUPING")
public class Group {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPECIALITY_ID", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Specialty specialty;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Teacher teacher;

    public Group() {
    }

    public Group(Teacher teacher, Subject subject) {

        this.specialty = teacher.getSpecialty();

        this.subject = subject;
        this.teacher = teacher;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    @ManyToMany(mappedBy = "groups")
    private Set<Student> students = new HashSet<Student>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;

//        for (Student student : students) {
//            student.getGroups().add(this);
//        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", specialty=" + specialty +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
