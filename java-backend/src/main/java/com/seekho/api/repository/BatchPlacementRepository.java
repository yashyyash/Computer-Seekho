package com.seekho.api.repository;

import com.seekho.api.entity.BatchPlacementMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchPlacementRepository extends JpaRepository<BatchPlacementMaster, Integer> {
}
