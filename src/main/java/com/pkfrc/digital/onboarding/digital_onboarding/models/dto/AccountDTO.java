package com.pkfrc.digital.onboarding.digital_onboarding.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pkfrc.digital.onboarding.digital_onboarding.models.Account;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class AccountDTO implements Serializable {

    @ApiModelProperty(notes = "The database generated employee ID")
    private Long id;

    @ApiModelProperty(notes = "Name of user")
    private String firstName;

    @ApiModelProperty(notes = "Surname of ser")
    private String lastName;

    @ApiModelProperty(notes = "Surname of ser")
    private String signature;

    @ApiModelProperty(notes = "Surname of ser")
    private String login;

    @ApiModelProperty(notes = "Surname of ser")
    private String email;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public AccountDTO() {
    }

    public AccountDTO(Long id) {
        this.id = id;
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
    }
}
