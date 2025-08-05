package com.seekho.api.serviceImpl;

import com.seekho.api.dto.StaffMasterDTO;
import com.seekho.api.entity.StaffMaster;
import com.seekho.api.mapper.StaffMasterMapper;
import com.seekho.api.repository.StaffMasterRepository;
import com.seekho.api.service.StaffMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffMasterServiceImpl implements StaffMasterService {

    @Autowired
    private StaffMasterRepository staffRepo;

    @Override
    public List<StaffMasterDTO> getAllStaff() {
        return staffRepo.findAll()
                .stream()
                .map(StaffMasterMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StaffMasterDTO getStaffById(int id) {
        StaffMaster staff = staffRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + id));
        return StaffMasterMapper.toDTO(staff);
    }

    @Override
    public StaffMasterDTO saveStaff(StaffMasterDTO dto) {
        StaffMaster staff = StaffMasterMapper.toEntity(dto);
        StaffMaster saved = staffRepo.save(staff);
        return StaffMasterMapper.toDTO(saved);
    }

    @Override
    public void deleteStaff(int id) {
        if (!staffRepo.existsById(id)) {
            throw new RuntimeException("Cannot delete. Staff with ID " + id + " not found.");
        }
        staffRepo.deleteById(id);
    }
}
