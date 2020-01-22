package com.pkfrc.digital.onboarding.digital_onboarding.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class AbstractAuditing {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private boolean activated = true;

    @Column(name="created_at", columnDefinition = "date")
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @Column(name="end_at")
    private ZonedDateTime endAt;

    @Column(name="created_by")
    private String createdBy;

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(ZonedDateTime endAt) {
        this.endAt = endAt;
    }
}
