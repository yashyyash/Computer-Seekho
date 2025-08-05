package com.seekho.api.controller;

import com.seekho.api.dto.ClosureReasonMasterDTO;
import com.seekho.api.service.ClosureReasonMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/closure-reasons")
public class ClosureReasonController {

    @Autowired
    private ClosureReasonMasterService closureReasonMasterService;

    @GetMapping
    public List<ClosureReasonMasterDTO> getAllClosureReasons() {
        return closureReasonMasterService.getAllClosureReasons();
    }

    @GetMapping("/{id}")
    public ClosureReasonMasterDTO getClosureReasonById(@PathVariable int id) {
        return closureReasonMasterService.getClosureReasonById(id);
    }


    @PostMapping
    public ClosureReasonMasterDTO createClosureReason(@RequestBody ClosureReasonMasterDTO dto) {
        return closureReasonMasterService.saveClosureReason(dto);
    }

    @PutMapping("/{id}")
    public ClosureReasonMasterDTO updateClosureReason(@PathVariable int id, @RequestBody ClosureReasonMasterDTO dto) {
        dto.setClosure_id(id); // ensure ID is updated
        return closureReasonMasterService.saveClosureReason(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClosureReason(@PathVariable int id) {
        closureReasonMasterService.deleteClosureReason(id);
    }
}
