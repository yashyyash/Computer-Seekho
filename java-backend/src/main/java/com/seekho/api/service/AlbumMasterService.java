package com.seekho.api.service;

import com.seekho.api.dto.AlbumMasterDTO;
import java.util.List;

public interface AlbumMasterService
{
    List<AlbumMasterDTO> getAllAlbums();
    AlbumMasterDTO getAlbumById(int id);
    AlbumMasterDTO saveAlbum(AlbumMasterDTO dto);
    void deleteAlbum(int id);
}
