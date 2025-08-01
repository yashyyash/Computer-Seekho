package com.seekho.api.dto;

import java.time.LocalDate;

public class FollowupDTO {

    private Integer followupId;
    private Integer enquiryId;
    private Integer staffId;
    private LocalDate followupDate;
    private String followupMsg;
    private Boolean isActive;

    // Getters and Setters

    public Integer getFollowupId() {
        return followupId;
    }

    public void setFollowupId(Integer followupId) {
        this.followupId = followupId;
    }

    public Integer getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public LocalDate getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(LocalDate followupDate) {
        this.followupDate = followupDate;
    }

    public String getFollowupMsg() {
        return followupMsg;
    }

    public void setFollowupMsg(String followupMsg) {
        this.followupMsg = followupMsg;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
