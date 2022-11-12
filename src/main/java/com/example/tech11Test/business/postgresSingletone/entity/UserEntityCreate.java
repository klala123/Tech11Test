package com.example.tech11Test.business.postgresSingletone.entity;

import com.example.tech11Test.business.abstractModule.AbstractModule;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserEntityCreate{
    @NotEmpty
    @Size(max = 50)
    private String firstName;
    @NotEmpty
    @Size(max = 50)
    private String lastName;
    @NotEmpty
    @Size(max = 100)
    private String email;
    private LocalDate birthDay;
    @NotNull
    private String password;

    public UserEntityDao toDaoEntity(){
        UserEntityDao userDao = new UserEntityDao();
        userDao.setFirstName(this.getFirstName());
        userDao.setLastName(this.getLastName());
        userDao.setEmail(this.getEmail());
        userDao.setBirthDay(this.getBirthDay());
        userDao.setPassword(this.getPassword());
        return userDao;
    }

    public UserEntityCreate(String firstName, String lastName, String email, LocalDate birthDay, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDay = birthDay;
        this.password = password;
    }

    public UserEntityCreate() {
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

    public String getPassword() {
        return password;
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
}
