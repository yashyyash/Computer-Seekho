package com.seekho.api.serviceImpl;

import com.seekho.api.dto.PlacedStudentDTO;
import com.seekho.api.entity.BatchPlacementMaster;
import com.seekho.api.entity.PlacedStudent;
import com.seekho.api.mapper.PlacedStudentMapper;
import com.seekho.api.repository.BatchPlacementRepository;
import com.seekho.api.repository.PlacedStudentRepository;
import com.seekho.api.service.PlacedStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacedStudentServiceImpl implements PlacedStudentService {
    private final PlacedStudentRepository studentRepo;
    private final BatchPlacementRepository batchRepo;
    private final PlacedStudentMapper mapper;

    public PlacedStudentServiceImpl(PlacedStudentRepository studentRepo, BatchPlacementRepository batchRepo, PlacedStudentMapper mapper) {
        this.studentRepo = studentRepo;
        this.batchRepo = batchRepo;
        this.mapper = mapper;
    }

    @Override
    public PlacedStudentDTO addStudent(PlacedStudentDTO dto) {
        BatchPlacementMaster batch = batchRepo.findById(Math.toIntExact(dto.getBatchId()))
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        PlacedStudent student = mapper.toEntity(dto, batch);
        return mapper.toDTO(studentRepo.save(student));
    }

    @Override
    public List<PlacedStudentDTO> getAllByBatch(Long batchId) {
        return studentRepo.findByBatch_BatchId(batchId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }


    @Override
    public PlacedStudentDTO updateStudent(Long id, PlacedStudentDTO dto) {
        PlacedStudent existing = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Optional: check batch exists
        BatchPlacementMaster batch = batchRepo.findById(Math.toIntExact(dto.getBatchId()))
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        existing.setStudentName(dto.getStudentName());
        existing.setCompanyName(dto.getCompanyName());
        existing.setPhotoUrl(dto.getPhotoUrl());
        existing.setActive(dto.getActive());
        existing.setBatch(batch);

        return mapper.toDTO(studentRepo.save(existing));
    }


    @Override
    public void deleteStudent(Long id) {
        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepo.deleteById(id);
    }
}
