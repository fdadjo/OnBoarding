package com.pkfrc.digital.onboarding.digital_onboarding.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pkfrc.digital.onboarding.digital_onboarding.models.enumeration.AccountType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "t_account")
@ApiModel(description = "All details about the Account.")
public class Account extends AbstractAuditing {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Account() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", user=" + user +
                '}';
    }
}
