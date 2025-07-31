package com.seekho.api.service;

import com.seekho.api.dto.PlacedStudentDTO;
import java.util.List;

public interface PlacedStudentService {
    PlacedStudentDTO addStudent(PlacedStudentDTO dto);
    List<PlacedStudentDTO> getAllByBatch(Long batchId);
    PlacedStudentDTO updateStudent(Long id, PlacedStudentDTO dto);
    void deleteStudent(Long id);
}
