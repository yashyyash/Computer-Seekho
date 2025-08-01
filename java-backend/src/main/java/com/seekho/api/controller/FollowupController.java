package com.seekho.api.controller;

import com.seekho.api.dto.FollowupDTO;
import com.seekho.api.service.FollowupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/followups")
public class FollowupController {

    @Autowired
    private FollowupService followupService;

    @PostMapping
    public FollowupDTO createFollowup(@RequestBody FollowupDTO followupDTO) {
        return followupService.createFollowup(followupDTO);
    }

    @PutMapping("/{followup_id}")
    public FollowupDTO updateFollowup(@PathVariable("followup_id") int followup_id,
                                      @RequestBody FollowupDTO followupDTO) {
        return followupService.updateFollowup(followup_id, followupDTO);
    }

    @DeleteMapping("/{followup_id}")
    public void deleteFollowup(@PathVariable("followup_id") int followup_id) {
        followupService.deleteFollowup(followup_id);
    }

    @GetMapping("/{followup_id}")
    public FollowupDTO getFollowupById(@PathVariable("followup_id") int followup_id) {
        return followupService.getFollowupById(followup_id);
    }

    @GetMapping
    public List<FollowupDTO> getAllFollowups() {
        return followupService.getAllFollowups();
    }
}
