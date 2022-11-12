package com.example.tech11Test.business.JavaObjectSingleton.users.entity;

import com.example.tech11Test.business.abstractModule.AbstractModule;

import java.io.Serializable;
import java.time.LocalDate;

public class UserEntity extends AbstractModule implements Serializable  {

    private long id ;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDay;
    private String password;

    public UserEntity(){}

    public UserEntity(String firstName, String lastName, String email, LocalDate birthDay, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDay = birthDay;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDay=" + birthDay +
                ", id=" + id +
                '}';
    }
}
