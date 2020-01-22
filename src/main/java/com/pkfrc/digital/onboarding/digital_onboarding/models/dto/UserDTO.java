package com.pkfrc.digital.onboarding.digital_onboarding.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pkfrc.digital.onboarding.digital_onboarding.models.User;

import javax.persistence.Column;
import java.util.Objects;

public class UserDTO  {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public UserDTO(User user) {
       this.id = user.getId();
       this.firstName = user.getFirstName();
       this.lastName = user.getLastName();
       this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, password, email);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
