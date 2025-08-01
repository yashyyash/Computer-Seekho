package com.seekho.api.mapper;

import com.seekho.api.dto.AlbumMasterDTO;
import com.seekho.api.entity.AlbumMaster;

public class AlbumMasterMapper
{

    public AlbumMasterDTO toDTO(AlbumMaster entity)
    {
        AlbumMasterDTO dto = new AlbumMasterDTO();

        dto.setAlbum_id(entity.getAlbumId());
        dto.setAlbum_name(entity.getAlbumName());
        dto.setAlbum_description(entity.getAlbumDescription());
        dto.setStart_date(entity.getStartDate());
        dto.setEnd_date(entity.getEndDate());
        dto.setAlbum_is_active(entity.isAlbumIsActive());

        return dto;
    }

    public AlbumMaster toEntity(AlbumMasterDTO dto)
    {
        AlbumMaster entity = new AlbumMaster();

        entity.setAlbumId(dto.getAlbum_id());
        entity.setAlbumName(dto.getAlbum_name());
        entity.setAlbumDescription(dto.getAlbum_description());
        entity.setStartDate(dto.getStart_date());
        entity.setEndDate(dto.getEnd_date());
        entity.setAlbumIsActive(dto.isAlbum_is_active());

        return entity;
    }
}
