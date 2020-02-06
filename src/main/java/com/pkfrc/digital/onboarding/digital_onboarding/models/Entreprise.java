package com.pkfrc.digital.onboarding.digital_onboarding.models;


import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_entreprise")
public class Entreprise extends AbstractAuditing {

    @Column
    private String entrepriseName;
    @Column
    private String telephone;

    @Column
    private String countryName;

    public Entreprise() {}

    public Entreprise(String schoolName, String telephone, String entrepriseName) {
        this.entrepriseName = entrepriseName;
        this.telephone = telephone;
        this.countryName = countryName;
    }

    public String getEntrepriseName() {
        return entrepriseName;
    }

    public void setEntrepriseName(String entrepriseName) {
        this.entrepriseName = entrepriseName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entreprise that = (Entreprise) o;
        return Objects.equals(entrepriseName, that.entrepriseName) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrepriseName, telephone, countryName);
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "entrepriseName='" + entrepriseName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
