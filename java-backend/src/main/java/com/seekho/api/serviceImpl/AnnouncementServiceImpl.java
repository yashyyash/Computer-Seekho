package com.seekho.api.serviceImpl;

import com.seekho.api.dto.AnnouncementDto;
import com.seekho.api.entity.Announcement;
import com.seekho.api.mapper.AnnouncementMapper;
import com.seekho.api.repository.AnnouncementRepository;
import com.seekho.api.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementRepository repo;

    @Override
    public AnnouncementDto save(AnnouncementDto dto) {
        Announcement entity = AnnouncementMapper.toEntity(dto);
        Announcement saved = repo.save(entity);
        return AnnouncementMapper.toDto(saved);
    }

    @Override
    public List<AnnouncementDto> getAll() {
        return repo.findAll()
                .stream()
                .map(AnnouncementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnnouncementDto getById(Integer id) {
        return repo.findById(id)
                .map(AnnouncementMapper::toDto)
                .orElse(null);
    }

    @Override
    public AnnouncementDto update(Integer id, AnnouncementDto dto) {
        Announcement existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setaDesc(dto.getaDesc());
            existing.setaIsActive(dto.getaIsActive());
            Announcement updated = repo.save(existing);
            return AnnouncementMapper.toDto(updated);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
