package com.seekho.api.controller;

import com.seekho.api.dto.ImageMasterDTO;
import com.seekho.api.service.ImageMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageMasterController
{
    @Autowired
    private ImageMasterService imageMasterService;

    @GetMapping
    public List<ImageMasterDTO> getAllImages() {
        return imageMasterService.getAllImages();
    }

    @GetMapping("/{id}")
    public ImageMasterDTO getImageById(@PathVariable int id) {
        return imageMasterService.getImageById(id);
    }

    @PostMapping
    public ImageMasterDTO createImage(@RequestBody ImageMasterDTO dto) {
        return imageMasterService.saveImage(dto);
    }

    @PutMapping("/{id}")
    public ImageMasterDTO updateImage(@PathVariable int id, @RequestBody ImageMasterDTO dto) {
        dto.setImage_id(id);
        return imageMasterService.saveImage(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable int id) {
        imageMasterService.deleteImage(id);
    }
}
