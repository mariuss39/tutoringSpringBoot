package com.example.tutoring.Lesson;

import com.example.tutoring.Subject.Subject;
import jakarta.persistence.*;

@Entity
@Table(name="lessons")
public class Lesson{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column (nullable=false)
    private String title;

    @Column (nullable=false)
    private int position;

    @Column(columnDefinition="TEXT")
    private String content;

    @ManyToOne(optional=false)
    @JoinColumn(name="subject_id",nullable=false) // inside the Lesson table,a refference to a subject
    private Subject subject;

    protected Lesson(){} //for JPA

    //constructors
    public Lesson(String title, int position, String content, Subject subject){
        this.title=title;
        this.position=position;
        this.content=content;
        this.subject=subject;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
