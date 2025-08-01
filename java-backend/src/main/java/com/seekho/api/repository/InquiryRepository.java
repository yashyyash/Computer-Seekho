package com.seekho.api.repository;

import com.seekho.api.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    // Optional: Add custom query methods here if needed
}
