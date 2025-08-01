package com.seekho.api.serviceImpl;

import com.seekho.api.dto.AlbumMasterDTO;
import com.seekho.api.entity.AlbumMaster;
import com.seekho.api.mapper.AlbumMasterMapper;
import com.seekho.api.repository.AlbumMasterRepository;
import com.seekho.api.service.AlbumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumMasterServiceImpl implements AlbumMasterService
{

    @Autowired
    private AlbumMasterRepository albumMasterRepository;

    private final AlbumMasterMapper mapper = new AlbumMasterMapper();

    @Override
    public List<AlbumMasterDTO> getAllAlbums()
    {
        List<AlbumMaster> albumList = albumMasterRepository.findAll();
        return albumList.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlbumMasterDTO getAlbumById(int id)
    {
        AlbumMaster album = albumMasterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found with ID: " + id));
        return mapper.toDTO(album);
    }

    @Override
    public AlbumMasterDTO saveAlbum(AlbumMasterDTO dto)
    {
        AlbumMaster album = mapper.toEntity(dto);
        AlbumMaster saved = albumMasterRepository.save(album);
        return mapper.toDTO(saved);
    }

    @Override
    public void deleteAlbum(int id)
    {
        albumMasterRepository.deleteById(id);
    }
}
