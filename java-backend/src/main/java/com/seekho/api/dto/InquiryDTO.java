package com.seekho.api.dto;

import java.time.LocalDate;
import com.seekho.api.entity.InquirySource;
import com.seekho.api.entity.InquiryStatus;

public class InquiryDTO {

    private int inquiryId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int inquiredCourseId;
    private InquirySource inquirySource;
    private LocalDate inquiryDate;
    private int assignedToStaffId;
    private InquiryStatus status;
    private LocalDate nextFollowUpDate;
    private String remarks;
    private String closureReason;

    // Getters and Setters

    public int getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(int inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getInquiredCourseId() {
        return inquiredCourseId;
    }

    public void setInquiredCourseId(int inquiredCourseId) {
        this.inquiredCourseId = inquiredCourseId;
    }

    public InquirySource getInquirySource() {
        return inquirySource;
    }

    public void setInquirySource(InquirySource inquirySource) {
        this.inquirySource = inquirySource;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDate inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public int getAssignedToStaffId() {
        return assignedToStaffId;
    }

    public void setAssignedToStaffId(int assignedToStaffId) {
        this.assignedToStaffId = assignedToStaffId;
    }

    public InquiryStatus getStatus() {
        return status;
    }

    public void setStatus(InquiryStatus status) {
        this.status = status;
    }

    public LocalDate getNextFollowUpDate() {
        return nextFollowUpDate;
    }

    public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
        this.nextFollowUpDate = nextFollowUpDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getClosureReason() {
        return closureReason;
    }

    public void setClosureReason(String closureReason) {
        this.closureReason = closureReason;
    }
}
