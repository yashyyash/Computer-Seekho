package com.seekho.api.repository;
import com.seekho.api.entity.Followup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowupRepository extends JpaRepository<Followup, Integer> {
    // You can define custom query methods here if needed
}
