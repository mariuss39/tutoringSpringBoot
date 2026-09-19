package com.example.tutoring.Subject;

import com.example.tutoring.Teacher.Teacher;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="subjects")
public class Subject{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(length=1000)
    private String description;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="teacher_id", nullable=false)
    private Teacher teacher;

    protected Subject(){}//for jpa

    //constructors
    public Subject (String name, String description, Teacher teacher){
        this.name=name;
        this.description=description;
        this.teacher=teacher;
    }
    public Subject (String name, String description){
        this.name=name;
        this.description=description;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

