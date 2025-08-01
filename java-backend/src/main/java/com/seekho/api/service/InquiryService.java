package com.seekho.api.service;

import com.seekho.api.dto.InquiryDTO;
import java.util.List;

public interface InquiryService {

    InquiryDTO getInquiryById(int id);

    List<InquiryDTO> getAllInquiries();

    InquiryDTO createInquiry(InquiryDTO inquiryDTO);

    InquiryDTO updateInquiry(int id, InquiryDTO inquiryDTO);

    void deleteInquiry(int id);
}
