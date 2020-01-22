package com.pkfrc.digital.onboarding.digital_onboarding.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pkfrc.digital.onboarding.digital_onboarding.models.enumeration.AccountType;
import com.pkfrc.digital.onboarding.digital_onboarding.models.enumeration.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_account")
@ApiModel(description = "All details about the Account.")
public class Account extends AbstractAuditing {

    @ApiModelProperty(notes = "The user link CNI")
    @Column
    private String linkCNI;
    @Column
    private String linkSignature;

    // Bank data
    @Column
    private String linkPicture;
    @Column
    private String linkHomePlan;

    // Assurance data
    @Column
    private String linkRegisterDocument;

    private AccountType accountType = AccountType.BANK;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Account() {
    }

    public Account(String linkCNI, String linkSignature, String linkPicture, String linkHomePlan, String linkRegisterDocument, AccountType accountType, User user) {
        this.linkCNI = linkCNI;
        this.linkSignature = linkSignature;
        this.linkPicture = linkPicture;
        this.linkHomePlan = linkHomePlan;
        this.linkRegisterDocument = linkRegisterDocument;
        this.accountType = accountType;
        this.user = user;
    }

    public String getLinkCNI() {
        return linkCNI;
    }

    public void setLinkCNI(String linkCNI) {
        this.linkCNI = linkCNI;
    }

    public String getLinkSignature() {
        return linkSignature;
    }

    public void setLinkSignature(String linkSignature) {
        this.linkSignature = linkSignature;
    }

    public String getLinkPicture() {
        return linkPicture;
    }

    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture;
    }

    public String getLinkHomePlan() {
        return linkHomePlan;
    }

    public void setLinkHomePlan(String linkHomePlan) {
        this.linkHomePlan = linkHomePlan;
    }

    public String getLinkRegisterDocument() {
        return linkRegisterDocument;
    }

    public void setLinkRegisterDocument(String linkRegisterDocument) {
        this.linkRegisterDocument = linkRegisterDocument;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(linkCNI, account.linkCNI) &&
                Objects.equals(linkSignature, account.linkSignature) &&
                Objects.equals(linkPicture, account.linkPicture) &&
                Objects.equals(linkHomePlan, account.linkHomePlan) &&
                Objects.equals(linkRegisterDocument, account.linkRegisterDocument) &&
                accountType == account.accountType &&
                Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkCNI, linkSignature, linkPicture, linkHomePlan, linkRegisterDocument, accountType, user);
    }

    @Override
    public String toString() {
        return "Account{" +
                "linkCNI='" + linkCNI + '\'' +
                ", linkSignature='" + linkSignature + '\'' +
                ", linkPicture='" + linkPicture + '\'' +
                ", linkHomePlan='" + linkHomePlan + '\'' +
                ", linkRegisterDocument='" + linkRegisterDocument + '\'' +
                ", accountType=" + accountType +
                ", user=" + user +
                '}';
    }
}
