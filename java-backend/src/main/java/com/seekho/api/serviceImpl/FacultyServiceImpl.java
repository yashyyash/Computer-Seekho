package com.seekho.api.serviceImpl;

import com.seekho.api.dto.FacultyDTO;
import com.seekho.api.entity.Faculty;
import com.seekho.api.mapper.FacultyMapper;
import com.seekho.api.repository.FacultyRepository;
import com.seekho.api.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<FacultyDTO> getAllActiveFaculty() {
        List<Faculty> faculties = facultyRepository.findByActiveTrue();
        return faculties.stream()
                .map(FacultyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found with ID: " + id));
        return FacultyMapper.toDTO(faculty);
    }

    @Override
    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = FacultyMapper.toEntity(facultyDTO);
        Faculty savedFaculty = facultyRepository.save(faculty);
        return FacultyMapper.toDTO(savedFaculty);
    }

    @Override
    public FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found with ID: " + id));

        faculty.setName(facultyDTO.getName());
        faculty.setSubject(facultyDTO.getSubject());
        faculty.setEmail(facultyDTO.getEmail());
        faculty.setPhotoUrl(facultyDTO.getPhotoUrl());

        Faculty updatedFaculty = facultyRepository.save(faculty);
        return FacultyMapper.toDTO(updatedFaculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        if (!facultyRepository.existsById(id)) {
            throw new RuntimeException("Faculty not found with ID: " + id);
        }
        facultyRepository.deleteById(id);
    }
}
