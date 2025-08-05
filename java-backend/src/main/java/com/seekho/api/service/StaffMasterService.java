package com.seekho.api.service;

import com.seekho.api.dto.StaffMasterDTO;

import java.util.List;

public interface StaffMasterService {
    List<StaffMasterDTO> getAllStaff();
    StaffMasterDTO getStaffById(int id);
    StaffMasterDTO saveStaff(StaffMasterDTO dto);
    void deleteStaff(int id);
}


