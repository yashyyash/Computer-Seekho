package com.seekho.api.service;

import com.seekho.api.dto.FollowupDTO;

import java.util.List;

public interface FollowupService {
    FollowupDTO createFollowup(FollowupDTO followupDTO);
    FollowupDTO getFollowupById(Integer id);
    List<FollowupDTO> getAllFollowups();
    FollowupDTO updateFollowup(Integer id, FollowupDTO followupDTO);
    void deleteFollowup(Integer id);
}
