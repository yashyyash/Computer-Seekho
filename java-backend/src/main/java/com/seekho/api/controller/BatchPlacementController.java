package com.seekho.api.controller;

import com.seekho.api.dto.BatchPlacementMasterDTO;
import com.seekho.api.service.BatchPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/batches")
public class BatchPlacementController {

    @Autowired
    private BatchPlacementService batchService;

    @GetMapping
    public List<BatchPlacementMasterDTO> getAllBatches() {
        return batchService.getAllBatches();
    }

    @GetMapping("/{id}")
    public BatchPlacementMasterDTO getBatchById(@PathVariable int id) {
        return batchService.getBatchById(id);
    }

    @PostMapping
    public BatchPlacementMasterDTO createBatch(@RequestBody BatchPlacementMasterDTO dto) {
        return batchService.saveBatch(dto);
    }

    @PutMapping("/{id}")
    public BatchPlacementMasterDTO updateBatch(@PathVariable int id, @RequestBody BatchPlacementMasterDTO dto) {
        dto.setBatchId(id); // ensure ID is set for update
        return batchService.saveBatch(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable int id) {
        batchService.deleteBatch(id);
    }
}
