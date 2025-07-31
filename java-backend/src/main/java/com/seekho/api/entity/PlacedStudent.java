package com.seekho.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "batchwise_placed_students")
public class PlacedStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private BatchPlacementMaster batch;

    private String studentName;
    private String companyName;
    private String photoUrl;
    private Boolean isActive;

    private LocalDateTime createdAt;

    // Getters & Setters

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public BatchPlacementMaster getBatch() {
        return batch;
    }

    public void setBatch(BatchPlacementMaster batch) {
        this.batch = batch;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
