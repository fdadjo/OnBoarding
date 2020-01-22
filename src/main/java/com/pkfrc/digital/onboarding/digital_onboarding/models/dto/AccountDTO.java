package com.pkfrc.digital.onboarding.digital_onboarding.models.dto;

import com.pkfrc.digital.onboarding.digital_onboarding.models.Account;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class AccountDTO implements Serializable {

    @ApiModelProperty(notes = "The database generated employee ID")
    private Long id;
    @ApiModelProperty(notes = "The user link CNI")
    private String linkCNI;
    @ApiModelProperty(notes = "The user link Signature")
    private String linkSignature;

    // Bank data
    @ApiModelProperty(notes = "The user link Picture")
    private String linkPicture;
    @ApiModelProperty(notes = "The user link Home Plan")
    private String linkHomePlan;

    // Assurance data
    @ApiModelProperty(notes = "The user link Car Register Document")
    private String linkRegisterDocument;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String linkCNI, String linkSignature, String linkPicture, String linkHomePlan, String linkRegisterDocument) {
        this.id = id;
        this.linkCNI = linkCNI;
        this.linkSignature = linkSignature;
        this.linkPicture = linkPicture;
        this.linkHomePlan = linkHomePlan;
        this.linkRegisterDocument = linkRegisterDocument;
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.linkCNI = account.getLinkCNI();
        this.linkSignature = account.getLinkSignature();
        this.linkPicture = account.getLinkPicture();
        this.linkHomePlan = account.getLinkHomePlan();
        this.linkRegisterDocument = account.getLinkRegisterDocument();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDTO that = (AccountDTO) o;
        return Objects.equals(linkCNI, that.linkCNI) &&
                Objects.equals(linkSignature, that.linkSignature) &&
                Objects.equals(linkPicture, that.linkPicture) &&
                Objects.equals(linkHomePlan, that.linkHomePlan) &&
                Objects.equals(linkRegisterDocument, that.linkRegisterDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkCNI, linkSignature, linkPicture, linkHomePlan, linkRegisterDocument);
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "linkCNI='" + linkCNI + '\'' +
                ", linkSignature='" + linkSignature + '\'' +
                ", linkPicture='" + linkPicture + '\'' +
                ", linkHomePlan='" + linkHomePlan + '\'' +
                ", linkRegisterDocument='" + linkRegisterDocument + '\'' +
                '}';
    }
}
