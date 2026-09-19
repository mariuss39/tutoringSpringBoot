package com.example.tutoring.User;

import jakarta.persistence.*;

@Entity
@Table(name="users")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
public abstract class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
    @Column (nullable=false)
    protected String name;
    @Column(nullable=false, unique=true)
    protected String email;
    @Column(nullable=false)
    protected String passwordHash;

    protected User(){} //for JPA

    //constructors
    protected User (String name,String email,String passwordHash){
        this.name=name;
        this.email=email;
        this.passwordHash=passwordHash;
    }

    //getter setter

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
