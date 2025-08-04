package com.seekho.api.service;

import com.seekho.api.dto.ImageMasterDTO;
import java.util.List;

public interface ImageMasterService
{
    List<ImageMasterDTO> getAllImages();
    ImageMasterDTO getImageById(int id);
    ImageMasterDTO saveImage(ImageMasterDTO dto);
    void deleteImage(int id);
}
