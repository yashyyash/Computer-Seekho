package com.seekho.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch_placement_master")
public class BatchPlacementMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batchId;

    private String batchName;
    private double placementPercentage;
    private String batchLogoUrl;
    private boolean isActive;

    private LocalDateTime createdAt;

    // Getters and Setters
    public int getBatchId() { return batchId; }
    public void setBatchId(int batchId) { this.batchId = batchId; }

    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }

    public double getPlacementPercentage() { return placementPercentage; }
    public void setPlacementPercentage(double placementPercentage) { this.placementPercentage = placementPercentage; }

    public String getBatchLogoUrl() { return batchLogoUrl; }
    public void setBatchLogoUrl(String batchLogoUrl) { this.batchLogoUrl = batchLogoUrl; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
