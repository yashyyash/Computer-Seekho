package com.seekho.api.service;

import com.seekho.api.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {
    List<FacultyDTO> getAllActiveFaculty();
    FacultyDTO getFacultyById(Long id);
    FacultyDTO createFaculty(FacultyDTO facultyDTO);
    FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO);
    void deleteFaculty(Long id);
}


