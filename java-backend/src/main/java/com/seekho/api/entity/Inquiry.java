package com.seekho.api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private int inquiryId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "inquired_course_id")
    private int inquiredCourseId;

    @Enumerated(EnumType.STRING)
    @Column(name = "inquiry_source")
    private InquirySource inquirySource;

    @Column(name = "inquiry_date")
    private LocalDate inquiryDate;

    @Column(name = "assigned_to_staff_id")
    private int assignedToStaffId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InquiryStatus status;

    @Column(name = "next_follow_up_date")
    private LocalDate nextFollowUpDate;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "closure_reason", columnDefinition = "TEXT")
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
