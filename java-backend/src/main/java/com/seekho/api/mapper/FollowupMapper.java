package com.seekho.api.mapper;

import com.seekho.api.dto.FollowupDTO;
import com.seekho.api.entity.Followup;

public class FollowupMapper {

    public static FollowupDTO toDTO(Followup entity) {
        if (entity == null) return null;

        FollowupDTO dto = new FollowupDTO();
        dto.setFollowupId(entity.getFollowup_id());
        dto.setEnquiryId(entity.getEnquiry_id());
        dto.setStaffId(entity.getStaff_id());
        dto.setFollowupDate(entity.getFollowup_date());
        dto.setFollowupMsg(entity.getFollowup_msg());
        dto.setIsActive(entity.getIs_active());
        return dto;
    }

    public static Followup toEntity(FollowupDTO dto) {
        if (dto == null) return null;

        Followup entity = new Followup();
        entity.setFollowup_id(dto.getFollowupId());
        entity.setEnquiry_id(dto.getEnquiryId());
        entity.setStaff_id(dto.getStaffId());
        entity.setFollowup_date(dto.getFollowupDate());
        entity.setFollowup_msg(dto.getFollowupMsg());
        entity.setIs_active(dto.getIsActive());
        return entity;
    }
}
