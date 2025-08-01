package com.seekho.api.controller;

import com.seekho.api.dto.AlbumMasterDTO;
import com.seekho.api.service.AlbumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumMasterController
{

    @Autowired
    private AlbumMasterService albumMasterService;

    @GetMapping
    public List<AlbumMasterDTO> getAllAlbums()
    {
        return albumMasterService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public AlbumMasterDTO getAlbumById(@PathVariable int id)
    {
        return albumMasterService.getAlbumById(id);
    }

    @PostMapping
    public AlbumMasterDTO createAlbum(@RequestBody AlbumMasterDTO dto)
    {
        return albumMasterService.saveAlbum(dto);
    }

    @PutMapping("/{id}")
    public AlbumMasterDTO updateAlbum(@PathVariable int id, @RequestBody AlbumMasterDTO dto)
    {
        dto.setAlbum_id(id); // ensure ID is set
        return albumMasterService.saveAlbum(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable int id)
    {
        albumMasterService.deleteAlbum(id);
    }
}
