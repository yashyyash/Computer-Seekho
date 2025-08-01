package com.seekho.api.mapper;

import com.seekho.api.dto.AnnouncementDto;
import com.seekho.api.entity.Announcement;

public class AnnouncementMapper {

    public static AnnouncementDto toDto(Announcement entity) {
        AnnouncementDto dto = new AnnouncementDto();
        dto.setaId(entity.getaId());
        dto.setaDesc(entity.getaDesc());
        dto.setaCreatedAt(entity.getaCreatedAt());
        dto.setaIsActive(entity.getaIsActive());
        return dto;
    }

    public static Announcement toEntity(AnnouncementDto dto) {
        Announcement entity = new Announcement();
        entity.setaId(dto.getaId());  // May be null for new records
        entity.setaDesc(dto.getaDesc());
        entity.setaCreatedAt(dto.getaCreatedAt());  // Optional
        entity.setaIsActive(dto.getaIsActive());
        return entity;
    }
}
