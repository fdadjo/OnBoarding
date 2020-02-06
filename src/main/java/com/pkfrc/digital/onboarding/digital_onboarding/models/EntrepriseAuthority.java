package com.pkfrc.digital.onboarding.digital_onboarding.models;

import javax.persistence.*;

@Entity
@Table(name = "t_entreprise_authority")
public class EntrepriseAuthority extends AbstractAuditing {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprise_id")
    private  Entreprise entreprise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id")
    private Authority role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public EntrepriseAuthority() {}

    public EntrepriseAuthority(Entreprise entreprise, Authority role, User user) {
        this.entreprise = entreprise;
        this.role = role;
        this.user = user;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Authority getRole() {
        return role;
    }

    public void setRole(Authority role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
