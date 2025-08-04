package com.seekho.api.serviceImpl;

import com.seekho.api.dto.PlacedStudentDTO;
import com.seekho.api.entity.BatchPlacementMaster;
import com.seekho.api.entity.PlacedStudent;
import com.seekho.api.mapper.PlacedStudentMapper;
import com.seekho.api.repository.BatchPlacementRepository;
import com.seekho.api.repository.PlacedStudentRepository;
import com.seekho.api.service.PlacedStudentService;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class PlacedStudentServiceImpl implements PlacedStudentService {

    private static final Logger logger = LogManager.getLogger(PlacedStudentServiceImpl.class);

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
        logger.info("Adding student: {}", dto.getStudentName());

        BatchPlacementMaster batch = batchRepo.findById(Math.toIntExact(dto.getBatchId()))
                .orElseThrow(() -> {
                    logger.error("Batch with ID {} not found", dto.getBatchId());
                    return new RuntimeException("Batch not found");
                });

        PlacedStudent student = mapper.toEntity(dto, batch);
        PlacedStudent saved = studentRepo.save(student);

        logger.debug("Student saved with ID: {}", saved.getStudentId());

        return mapper.toDTO(saved);
    }

    @Override
    public List<PlacedStudentDTO> getAllByBatch(Long batchId) {
        logger.info("Fetching all placed students for batch ID: {}", batchId);

        List<PlacedStudentDTO> students = studentRepo.findByBatch_BatchId(batchId)
                .stream()
                .map(mapper::toDTO)
                .toList();

        logger.debug("Found {} students", students.size());
        return students;
    }

    @Override
    public PlacedStudentDTO updateStudent(Long id, PlacedStudentDTO dto) {
        logger.info("Updating student with ID: {}", id);

        PlacedStudent existing = studentRepo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student with ID {} not found", id);
                    return new RuntimeException("Student not found");
                });

        BatchPlacementMaster batch = batchRepo.findById(Math.toIntExact(dto.getBatchId()))
                .orElseThrow(() -> {
                    logger.error("Batch with ID {} not found", dto.getBatchId());
                    return new RuntimeException("Batch not found");
                });

        existing.setStudentName(dto.getStudentName());
        existing.setCompanyName(dto.getCompanyName());
        existing.setPhotoUrl(dto.getPhotoUrl());
        existing.setActive(dto.getActive());
        existing.setBatch(batch);

        PlacedStudent saved = studentRepo.save(existing);

        logger.debug("Student with ID {} updated", id);
        return mapper.toDTO(saved);
    }

    @Override
    public void deleteStudent(Long id) {
        logger.info("Deleting student with ID: {}", id);

        if (!studentRepo.existsById(id)) {
            logger.error("Cannot delete student. ID {} not found.", id);
            throw new RuntimeException("Student not found");
        }

        studentRepo.deleteById(id);
        logger.debug("Student with ID {} deleted", id);
    }
}
