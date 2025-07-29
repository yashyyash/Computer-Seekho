package com.seekho.api.mapper;

import com.seekho.api.entity.BatchPlacementMaster;
import com.seekho.api.dto.BatchPlacementMasterDTO;
import org.springframework.stereotype.Component;

@Component
public class BatchPlacementMapper {

    public BatchPlacementMasterDTO toDTO(BatchPlacementMaster entity) {
        BatchPlacementMasterDTO dto = new BatchPlacementMasterDTO();
        dto.setBatchId(entity.getBatchId());
        dto.setBatchName(entity.getBatchName());
        dto.setPlacementPercentage(entity.getPlacementPercentage());
        dto.setBatchLogoUrl(entity.getBatchLogoUrl());
        dto.setIsActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public BatchPlacementMaster toEntity(BatchPlacementMasterDTO dto) {
        BatchPlacementMaster entity = new BatchPlacementMaster();
        entity.setBatchId(dto.getBatchId());
        entity.setBatchName(dto.getBatchName());
        entity.setPlacementPercentage(dto.getPlacementPercentage());
        entity.setBatchLogoUrl(dto.getBatchLogoUrl());
        entity.setActive(dto.isActive());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
