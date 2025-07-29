package com.seekho.api.service;

import com.seekho.api.dto.BatchPlacementMasterDTO;
import java.util.List;

public interface BatchPlacementService {
    List<BatchPlacementMasterDTO> getAllBatches();
    BatchPlacementMasterDTO getBatchById(int id);
    BatchPlacementMasterDTO saveBatch(BatchPlacementMasterDTO dto);
    void deleteBatch(int id);
}
