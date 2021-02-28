package com.kucherenko.spring.spring_hibernate_mvc.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="AGE")
    private int age;

    @Column(name="IS_ADMIN")
    private boolean isAdmin;

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    public User(int id, String name, int age, boolean isAdmin, Timestamp createdDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public User() {
    }
}
