package com.seekho.api.serviceImpl;


import com.seekho.api.dto.ClosureReasonMasterDTO;
import com.seekho.api.entity.ClosureReasonMaster;
import com.seekho.api.mapper.ClosureReasonMasterMapper;
import com.seekho.api.repository.ClosureReasonMasterRepository;
import com.seekho.api.service.ClosureReasonMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClosureReasonMasterServiceImpl implements ClosureReasonMasterService {

    @Autowired
    private ClosureReasonMasterRepository repository;

    // Either add @Component to the mapper or use new keyword
    private final ClosureReasonMasterMapper mapper = new ClosureReasonMasterMapper();

    @Override
    public List<ClosureReasonMasterDTO> getAllClosureReasons() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClosureReasonMasterDTO getClosureReasonById(int id) {
        ClosureReasonMaster entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Closure reason not found with ID: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public ClosureReasonMasterDTO saveClosureReason(ClosureReasonMasterDTO dto) {
        ClosureReasonMaster entity = mapper.toEntity(dto);
        ClosureReasonMaster saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public void deleteClosureReason(int id) {
        repository.deleteById(id);
    }
}
