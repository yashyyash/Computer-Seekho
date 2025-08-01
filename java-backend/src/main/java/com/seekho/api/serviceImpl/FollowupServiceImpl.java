package com.seekho.api.serviceImpl;

import com.seekho.api.dto.FollowupDTO;
import com.seekho.api.entity.Followup;
import com.seekho.api.mapper.FollowupMapper;
import com.seekho.api.repository.FollowupRepository;
import com.seekho.api.service.FollowupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FollowupServiceImpl implements FollowupService {

    @Autowired
    private FollowupRepository followupRepository;

    @Override
    public FollowupDTO createFollowup(FollowupDTO followupDTO) {
        Followup entity = FollowupMapper.toEntity(followupDTO);
        Followup saved = followupRepository.save(entity);
        return FollowupMapper.toDTO(saved);
    }

    @Override
    public FollowupDTO getFollowupById(Integer id) {
        Optional<Followup> optional = followupRepository.findById(id);
        return optional.map(FollowupMapper::toDTO).orElse(null);
    }

    @Override
    public List<FollowupDTO> getAllFollowups() {
        List<Followup> list = followupRepository.findAll();
        return list.stream()
                .map(FollowupMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FollowupDTO updateFollowup(Integer id, FollowupDTO followupDTO) {
        Optional<Followup> optional = followupRepository.findById(id);
        if (optional.isPresent()) {
            Followup existing = optional.get();
            existing.setEnquiry_id(followupDTO.getEnquiryId());
            existing.setStaff_id(followupDTO.getStaffId());
            existing.setFollowup_date(followupDTO.getFollowupDate());
            existing.setFollowup_msg(followupDTO.getFollowupMsg());
            existing.setIs_active(followupDTO.getIsActive());
            Followup updated = followupRepository.save(existing);
            return FollowupMapper.toDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteFollowup(Integer id) {
        followupRepository.deleteById(id);
    }
}
