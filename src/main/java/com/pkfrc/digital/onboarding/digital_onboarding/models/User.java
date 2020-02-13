package com.pkfrc.digital.onboarding.digital_onboarding.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pkfrc.digital.onboarding.digital_onboarding.models.enumeration.UserType;
import io.swagger.annotations.ApiModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table(name = "t_user")
@ApiModel(description = "All details about the User.")
public class User extends AbstractAuditing implements UserDetails {

    @Column(unique = true)
    private String login;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String namePicture;
    @Column
    private ZonedDateTime date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Account> accountList = new ArrayList<>();

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, String email, UserType userType, String langKey, List<Account> accountList) {
        this.login = login;
        //this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        //this.userType = userType;
        //this.langKey = langKey;
        this.accountList = accountList;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
