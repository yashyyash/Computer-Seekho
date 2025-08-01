package com.seekho.api.service;

import com.seekho.api.dto.AnnouncementDto;

import java.util.List;

public interface AnnouncementService {
    AnnouncementDto save(AnnouncementDto dto);
    List<AnnouncementDto> getAll();
    AnnouncementDto getById(Integer id);
    AnnouncementDto update(Integer id, AnnouncementDto dto);
    void delete(Integer id);
}
