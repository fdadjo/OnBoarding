package com.pkfrc.digital.onboarding.digital_onboarding.models;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Authority implements GrantedAuthority {

    @Column
    @Id
    private String name;

    public Authority() {
    }

    public Authority(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean equalsAuthority(Authority obj) {
        if (this.name.equals(obj.getName())) {
            return true;
        } else  {
            return false;
        }
    }
}
