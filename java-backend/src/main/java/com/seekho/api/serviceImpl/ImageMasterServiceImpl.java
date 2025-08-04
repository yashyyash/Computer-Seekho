package com.seekho.api.serviceImpl;

import com.seekho.api.dto.ImageMasterDTO;
import com.seekho.api.entity.ImageMaster;
import com.seekho.api.mapper.ImageMasterMapper;
import com.seekho.api.repository.ImageMasterRepository;
import com.seekho.api.service.ImageMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageMasterServiceImpl implements ImageMasterService
{

    @Autowired
    private ImageMasterRepository imageMasterRepository;

    private final ImageMasterMapper mapper = new ImageMasterMapper();

    @Override
    public List<ImageMasterDTO> getAllImages()
    {
        return imageMasterRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ImageMasterDTO getImageById(int id)
    {
        ImageMaster image = imageMasterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with ID: " + id));
        return mapper.toDTO(image);
    }

    @Override
    public ImageMasterDTO saveImage(ImageMasterDTO dto) {
        ImageMaster entity = mapper.toEntity(dto);
        ImageMaster saved = imageMasterRepository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public void deleteImage(int id) {
        imageMasterRepository.deleteById(id);
    }
}
