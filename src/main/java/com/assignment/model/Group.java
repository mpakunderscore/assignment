package com.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="GROUP")
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

    //    private Set<Student> students;

    public void addStudent(Student student) {
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", specialty=" + specialty +
                ", subject=" + subject +
                ", teacher=" + teacher +
                '}';
    }
}
