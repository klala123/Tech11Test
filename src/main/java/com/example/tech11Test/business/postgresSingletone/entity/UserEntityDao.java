package com.example.tech11Test.business.postgresSingletone.entity;

import com.example.tech11Test.business.abstractModule.AbstractModule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class UserEntityDao {
    @Id
    @GeneratedValue
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntityDao(String firstName, String lastName, String email, LocalDate birthDay, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDay = birthDay;
        this.password = password;
    }

    public UserEntityDao() {
    }

    public UserEntityDTO toDTOEntity(){
        UserEntityDTO dtoEntity = new UserEntityDTO();
        dtoEntity.setId(this.getId());
        dtoEntity.setFirstName(this.getFirstName());
        dtoEntity.setLastName(this.getLastName());
        dtoEntity.setEmail(this.getEmail());
        return dtoEntity;
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

        public  void updatePropertiesDao(final UserEntityDao userToUpdate) {
            this.setFirstName(userToUpdate.getFirstName());
            this.setLastName(userToUpdate.getLastName());
            this.setEmail(userToUpdate.getEmail());
            this.setPassword(userToUpdate.getPassword());
            this.setBirthDay(userToUpdate.getBirthDay());
        }

        public  void updateThePassword(final UserEntityDao userToUpdate) {
            this.setPassword(userToUpdate.getPassword());
        }

    @Override
    public String toString() {
        return "UserEntity_{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDay=" + birthDay +
                ", password='" + password + '\'' +
                '}';
    }
}
