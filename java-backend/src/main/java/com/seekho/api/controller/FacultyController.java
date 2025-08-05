package com.seekho.api.controller;

import com.seekho.api.dto.FacultyDTO;
import com.seekho.api.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//   GET: /api/faculty
//   GET BY ID: /api/faculty/{Id}
//   POST ID:   /api/faculty
//   PUT BY ID: /api/faculty/{Id}
//   Delete by ID: /api/faculty/{Id}
@RequestMapping("/api/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<FacultyDTO> getAllActiveFaculty() {
        return facultyService.getAllActiveFaculty();
    }

    @GetMapping("/{id}")
    public FacultyDTO getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    @PostMapping
    public FacultyDTO createFaculty(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.createFaculty(facultyDTO);
    }

    @PutMapping("/{id}")
    public FacultyDTO updateFaculty(@PathVariable Long id, @RequestBody FacultyDTO facultyDTO) {
        return facultyService.updateFaculty(id, facultyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }
}


