package com.seekho.api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "followup")
public class Followup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followup_id")
    private Integer followup_id;

    @Column(name = "enquiry_id")
    private Integer enquiry_id;

    @Column(name = "staff_id")
    private Integer staff_id;

    @Column(name = "followup_date")
    private LocalDate followup_date;

    @Column(name = "followup_msg", length = 150)
    private String followup_msg;

    @Column(name = "is_active")
    private Boolean is_active = false;

    // Getters and Setters

    public Integer getFollowup_id() {
        return followup_id;
    }

    public void setFollowup_id(Integer followup_id) {
        this.followup_id = followup_id;
    }

    public Integer getEnquiry_id() {
        return enquiry_id;
    }

    public void setEnquiry_id(Integer enquiry_id) {
        this.enquiry_id = enquiry_id;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public LocalDate getFollowup_date() {
        return followup_date;
    }

    public void setFollowup_date(LocalDate followup_date) {
        this.followup_date = followup_date;
    }

    public String getFollowup_msg() {
        return followup_msg;
    }

    public void setFollowup_msg(String followup_msg) {
        this.followup_msg = followup_msg;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
