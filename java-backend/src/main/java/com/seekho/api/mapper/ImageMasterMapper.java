package com.seekho.api.mapper;

import com.seekho.api.dto.ImageMasterDTO;
import com.seekho.api.entity.ImageMaster;

public class ImageMasterMapper
{

    public ImageMasterDTO toDTO(ImageMaster entity)
    {
        ImageMasterDTO dto = new ImageMasterDTO();
        dto.setImage_id(entity.getImageId());
        dto.setImage_path(entity.getImagePath());
        dto.setAlbum_id(entity.getAlbumId());
        dto.setIs_album_cover(entity.isAlbumCover());
        dto.setImage_is_active(entity.isImageIsActive());
        return dto;
    }

    public ImageMaster toEntity(ImageMasterDTO dto)
    {
        ImageMaster entity = new ImageMaster();
        entity.setImageId(dto.getImage_id());
        entity.setImagePath(dto.getImage_path());
        entity.setAlbumId(dto.getAlbum_id());
        entity.setAlbumCover(dto.isIs_album_cover());
        entity.setImageIsActive(dto.isImage_is_active());
        return entity;
    }
}
