package com.example.tutoring.Student;

import com.example.tutoring.User.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {

    protected Student(){} // for JPA
    //constructors
    public Student(String name, String email, String passwordHash){
        super(name,email,passwordHash);
    }

    @Override

    public String getRole(){
        return "STUDENT";
    }

}
