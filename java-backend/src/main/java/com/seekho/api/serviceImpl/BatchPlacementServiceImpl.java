package com.seekho.api.serviceImpl;

import com.seekho.api.dto.BatchPlacementMasterDTO;
import com.seekho.api.entity.BatchPlacementMaster;
import com.seekho.api.mapper.BatchPlacementMapper;
import com.seekho.api.repository.BatchPlacementRepository;
import com.seekho.api.service.BatchPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchPlacementServiceImpl implements BatchPlacementService {

    @Autowired
    private BatchPlacementRepository repository;

    @Autowired
    private BatchPlacementMapper mapper;

    @Override
    public List<BatchPlacementMasterDTO> getAllBatches() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BatchPlacementMasterDTO getBatchById(int id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public BatchPlacementMasterDTO saveBatch(BatchPlacementMasterDTO dto) {
        BatchPlacementMaster entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void deleteBatch(int id) {
        repository.deleteById(id);
    }
}
