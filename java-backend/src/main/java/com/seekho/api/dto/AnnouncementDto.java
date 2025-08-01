package com.seekho.api.dto;

import java.time.LocalDateTime;

public class AnnouncementDto {
    private Integer aId;
    private String aDesc;
    private LocalDateTime aCreatedAt;
    private Boolean aIsActive;

    public Integer getaId() { return aId; }
    public void setaId(Integer aId) { this.aId = aId; }

    public String getaDesc() { return aDesc; }
    public void setaDesc(String aDesc) { this.aDesc = aDesc; }

    public LocalDateTime getaCreatedAt() { return aCreatedAt; }
    public void setaCreatedAt(LocalDateTime aCreatedAt) { this.aCreatedAt = aCreatedAt; }

    public Boolean getaIsActive() { return aIsActive; }
    public void setaIsActive(Boolean aIsActive) { this.aIsActive = aIsActive; }
}
