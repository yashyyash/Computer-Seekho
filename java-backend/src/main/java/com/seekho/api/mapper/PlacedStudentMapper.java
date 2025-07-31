package com.seekho.api.mapper;
import com.seekho.api.entity.BatchPlacementMaster;
import com.seekho.api.entity.PlacedStudent;
import com.seekho.api.dto.PlacedStudentDTO;
import org.springframework.stereotype.Component;

@Component
public class PlacedStudentMapper {
    public PlacedStudentDTO toDTO(PlacedStudent student) {
        PlacedStudentDTO dto = new PlacedStudentDTO();
        dto.setId(student.getStudentId());
        dto.setBatchId((long) student.getBatch().getBatchId());
        dto.setStudentName(student.getStudentName());
        dto.setCompanyName(student.getCompanyName());
        dto.setPhotoUrl(student.getPhotoUrl());
        dto.setActive(student.getActive());
        return dto;
    }

    public PlacedStudent toEntity(PlacedStudentDTO dto, BatchPlacementMaster batch) {
        PlacedStudent student = new PlacedStudent();
        student.setBatch(batch);
        student.setStudentName(dto.getStudentName());
        student.setCompanyName(dto.getCompanyName());
        student.setPhotoUrl(dto.getPhotoUrl());
        student.setActive(dto.getActive());
        return student;
    }
}
