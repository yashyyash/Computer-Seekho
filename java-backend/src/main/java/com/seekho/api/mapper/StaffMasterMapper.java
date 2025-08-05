package com.seekho.api.mapper;

import com.seekho.api.dto.StaffMasterDTO;
import com.seekho.api.entity.StaffMaster;

public class StaffMasterMapper {

    public static StaffMasterDTO toDTO(StaffMaster entity) {
        StaffMasterDTO dto = new StaffMasterDTO();
        dto.setStaffId(entity.getStaffId());
        dto.setStaffName(entity.getStaffName());
        dto.setPhotoUrl(entity.getPhotoUrl());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setStaffRole(entity.getStaffRole());
        return dto;
    }

    public static StaffMaster toEntity(StaffMasterDTO dto) {
        StaffMaster entity = new StaffMaster();
        entity.setStaffId(dto.getStaffId());
        entity.setStaffName(dto.getStaffName());
        entity.setPhotoUrl(dto.getPhotoUrl());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setStaffRole(dto.getStaffRole());
        return entity;
    }
}

