package com.seekho.api.controller;

import com.seekho.api.dto.PlacedStudentDTO;
import com.seekho.api.service.PlacedStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/students")
public class PlacedStudentController {
    private final PlacedStudentService service;

    public PlacedStudentController(PlacedStudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PlacedStudentDTO> create(@RequestBody PlacedStudentDTO dto) {
        return ResponseEntity.ok(service.addStudent(dto));
    }

    @GetMapping("/batch/{batchId}")
    public ResponseEntity<List<PlacedStudentDTO>> getByBatch(@PathVariable Long batchId) {
        return ResponseEntity.ok(service.getAllByBatch(batchId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlacedStudentDTO> updateStudent(
            @PathVariable Long id,
            @RequestBody PlacedStudentDTO dto) {
        return ResponseEntity.ok(service.updateStudent(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
