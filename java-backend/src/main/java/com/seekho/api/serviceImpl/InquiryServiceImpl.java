package com.seekho.api.serviceImpl;

import com.seekho.api.dto.InquiryDTO;
import com.seekho.api.entity.Inquiry;
import com.seekho.api.mapper.InquiryMapper;
import com.seekho.api.repository.InquiryRepository;
import com.seekho.api.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    @Override
    public InquiryDTO getInquiryById(int id) {
        Optional<Inquiry> inquiry = inquiryRepository.findById(id);
        return inquiry.map(InquiryMapper::toDTO).orElse(null);
    }

    @Override
    public List<InquiryDTO> getAllInquiries() {
        List<Inquiry> inquiries = inquiryRepository.findAll();
        return inquiries.stream()
                .map(InquiryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InquiryDTO createInquiry(InquiryDTO inquiryDTO) {
        Inquiry entity = InquiryMapper.toEntity(inquiryDTO);
        Inquiry saved = inquiryRepository.save(entity);
        return InquiryMapper.toDTO(saved);
    }

    @Override
    public InquiryDTO updateInquiry(int id, InquiryDTO inquiryDTO) {
        Optional<Inquiry> optional = inquiryRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Inquiry existing = optional.get();

        // Update fields
        existing.setFirstName(inquiryDTO.getFirstName());
        existing.setLastName(inquiryDTO.getLastName());
        existing.setPhoneNumber(inquiryDTO.getPhoneNumber());
        existing.setEmail(inquiryDTO.getEmail());
        existing.setInquiredCourseId(inquiryDTO.getInquiredCourseId());
        existing.setInquirySource(inquiryDTO.getInquirySource());
        existing.setInquiryDate(inquiryDTO.getInquiryDate());
        existing.setAssignedToStaffId(inquiryDTO.getAssignedToStaffId());
        existing.setStatus(inquiryDTO.getStatus());
        existing.setNextFollowUpDate(inquiryDTO.getNextFollowUpDate());
        existing.setRemarks(inquiryDTO.getRemarks());
        existing.setClosureReason(inquiryDTO.getClosureReason());

        Inquiry updated = inquiryRepository.save(existing);
        return InquiryMapper.toDTO(updated);
    }

    @Override
    public void deleteInquiry(int id) {
        inquiryRepository.deleteById(id);
    }
}
