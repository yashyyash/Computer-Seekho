package com.seekho.api.controller;

import com.seekho.api.dto.InquiryDTO;
import com.seekho.api.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
//@CrossOrigin(origins = "http://localhost:5173") // React frontend port
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    // Get All Inquiries
    @GetMapping
    public ResponseEntity<List<InquiryDTO>> getAllInquiries() {
        List<InquiryDTO> inquiries = inquiryService.getAllInquiries();
        return ResponseEntity.ok(inquiries);
    }

    // Get Inquiry by ID
    @GetMapping("/{id}")
    public ResponseEntity<InquiryDTO> getInquiryById(@PathVariable int id) {
        InquiryDTO inquiry = inquiryService.getInquiryById(id);
        if (inquiry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inquiry);
    }

    // Create Inquiry
    @PostMapping
    public ResponseEntity<InquiryDTO> createInquiry(@RequestBody InquiryDTO inquiryDTO) {
        InquiryDTO created = inquiryService.createInquiry(inquiryDTO);
        return ResponseEntity.ok(created);
    }

    // Update Inquiry
    @PutMapping("/{id}")
    public ResponseEntity<InquiryDTO> updateInquiry(@PathVariable int id, @RequestBody InquiryDTO inquiryDTO) {
        InquiryDTO updated = inquiryService.updateInquiry(id, inquiryDTO);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Delete Inquiry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable int id) {
        inquiryService.deleteInquiry(id);
        return ResponseEntity.noContent().build();
    }
}
