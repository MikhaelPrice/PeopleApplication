package com.SpringBoot.PeopleApplication.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @NotEmpty(message = "name shouldn't be empty")
    @Size(min = 2, max = 40, message = "name should be between 2 and 40 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @Min(value = 0, message = "Age should be more than 0")
    @Column(name = "age", nullable = false)
    private int age;

    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Invalid email")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Long id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
