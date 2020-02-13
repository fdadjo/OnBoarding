package com.pkfrc.digital.onboarding.digital_onboarding.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pkfrc.digital.onboarding.digital_onboarding.models.Account;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.ZonedDateTime;

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

    @ApiModelProperty(notes = "Picture")
    private String picture;

    @ApiModelProperty(notes = "name of picture")
    private String namePicture;

    @ApiModelProperty(notes = "Birth date")
    private String date;


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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
