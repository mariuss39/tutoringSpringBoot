package com.example.tutoring.Teacher;

import com.example.tutoring.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends User {

    @Column(length=1000)
    private String description;

    protected Teacher(){} // For JPA

    //constructors
    public Teacher (String name,String email,String passwordHash,String description){
        super(name,email,passwordHash);
        this.description=description;}

    //getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getRole(){
        return "TEACHER";
    }
}
