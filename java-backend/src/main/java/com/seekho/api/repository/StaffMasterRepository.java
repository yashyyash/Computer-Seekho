package com.seekho.api.repository;

import com.seekho.api.entity.StaffMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffMasterRepository extends JpaRepository<StaffMaster, Integer> {
}