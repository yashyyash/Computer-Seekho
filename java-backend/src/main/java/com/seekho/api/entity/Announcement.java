package com.seekho.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;
    private String aDesc;
    private LocalDateTime aCreatedAt;
    private Boolean aIsActive;

    @PrePersist
    public void prePersist() {
        this.aCreatedAt = LocalDateTime.now();
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaDesc() {
        return aDesc;
    }

    public void setaDesc(String aDesc) {
        this.aDesc = aDesc;
    }

    public LocalDateTime getaCreatedAt() {
        return aCreatedAt;
    }

    public void setaCreatedAt(LocalDateTime aCreatedAt) {
        this.aCreatedAt = aCreatedAt;
    }

    public Boolean getaIsActive() {
        return aIsActive;
    }

    public void setaIsActive(Boolean aIsActive) {
        this.aIsActive = aIsActive;
    }
}
