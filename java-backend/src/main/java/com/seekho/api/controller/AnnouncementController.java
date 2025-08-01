package com.seekho.api.controller;

import com.seekho.api.dto.AnnouncementDto;
import com.seekho.api.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@CrossOrigin(origins = "http://localhost:5173")
public class AnnouncementController {

    @Autowired
    private AnnouncementService service;

    @PostMapping
    public AnnouncementDto create(@RequestBody AnnouncementDto dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<AnnouncementDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AnnouncementDto getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public AnnouncementDto update(@PathVariable Integer id, @RequestBody AnnouncementDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
