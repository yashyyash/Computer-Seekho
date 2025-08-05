package com.seekho.api.controller;

import com.seekho.api.dto.StaffMasterDTO;
import com.seekho.api.service.StaffMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staffs")
public class StaffMasterController {

    @Autowired
    private StaffMasterService staffService;

    @GetMapping
    public List<StaffMasterDTO> getAllStaffs() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public StaffMasterDTO getStaffById(@PathVariable int id) {
        return staffService.getStaffById(id);
    }

    @PostMapping
    public StaffMasterDTO createStaff(@RequestBody StaffMasterDTO dto) {
        return staffService.saveStaff(dto);
    }

    @PutMapping("/{id}")
    public StaffMasterDTO updateStaff(@PathVariable int id, @RequestBody StaffMasterDTO dto) {
        dto.setStaffId(id); // ensure ID is correctly set
        return staffService.saveStaff(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable int id) {
        staffService.deleteStaff(id);
    }
}

