package com.seekho.api.mapper;

import com.seekho.api.entity.Inquiry;
import com.seekho.api.dto.InquiryDTO;

public class InquiryMapper {

    // Convert Entity to DTO
    public static InquiryDTO toDTO(Inquiry inquiry) {
        if (inquiry == null) {
            return null;
        }

        InquiryDTO dto = new InquiryDTO();
        dto.setInquiryId(inquiry.getInquiryId());
        dto.setFirstName(inquiry.getFirstName());
        dto.setLastName(inquiry.getLastName());
        dto.setPhoneNumber(inquiry.getPhoneNumber());
        dto.setEmail(inquiry.getEmail());
        dto.setInquiredCourseId(inquiry.getInquiredCourseId());
        dto.setInquirySource(inquiry.getInquirySource());
        dto.setInquiryDate(inquiry.getInquiryDate());
        dto.setAssignedToStaffId(inquiry.getAssignedToStaffId());
        dto.setStatus(inquiry.getStatus());
        dto.setNextFollowUpDate(inquiry.getNextFollowUpDate());
        dto.setRemarks(inquiry.getRemarks());
        dto.setClosureReason(inquiry.getClosureReason());
        return dto;
    }

    // Convert DTO to Entity
    public static Inquiry toEntity(InquiryDTO dto) {
        if (dto == null) {
            return null;
        }

        Inquiry inquiry = new Inquiry();
        inquiry.setInquiryId(dto.getInquiryId());
        inquiry.setFirstName(dto.getFirstName());
        inquiry.setLastName(dto.getLastName());
        inquiry.setPhoneNumber(dto.getPhoneNumber());
        inquiry.setEmail(dto.getEmail());
        inquiry.setInquiredCourseId(dto.getInquiredCourseId());
        inquiry.setInquirySource(dto.getInquirySource());
        inquiry.setInquiryDate(dto.getInquiryDate());
        inquiry.setAssignedToStaffId(dto.getAssignedToStaffId());
        inquiry.setStatus(dto.getStatus());
        inquiry.setNextFollowUpDate(dto.getNextFollowUpDate());
        inquiry.setRemarks(dto.getRemarks());
        inquiry.setClosureReason(dto.getClosureReason());
        return inquiry;
    }
}
