package com.seekho.api.repository;

import com.seekho.api.entity.PlacedStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacedStudentRepository extends JpaRepository<PlacedStudent, Long> {
    List<PlacedStudent> findByBatch_BatchId(Long batchId);
}
