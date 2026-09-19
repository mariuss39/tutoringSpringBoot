package com.example.tutoring.Enrollment;

import com.example.tutoring.Student.Student;
import com.example.tutoring.Subject.Subject;
import jakarta.persistence.*;

@Entity
@Table(name="enrollments", uniqueConstraints=@UniqueConstraint(columnNames={"student_id","subject_id"}))
public class Enrollment{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="student_id",nullable=false)
    private Student student;

    @ManyToOne (fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="subject_id",nullable=false)
    private Subject subject;

    protected Enrollment(){}//FOR JPA

    //constructors
    public Enrollment(Student student, Subject subject){
        this.student=student;
        this.subject=subject;}

    //getters and setters

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
