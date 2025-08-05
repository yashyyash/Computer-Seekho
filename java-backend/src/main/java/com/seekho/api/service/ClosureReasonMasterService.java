package com.seekho.api.service;

import com.seekho.api.dto.ClosureReasonMasterDTO;
import java.util.List;

public interface ClosureReasonMasterService {

    List<ClosureReasonMasterDTO> getAllClosureReasons();
    ClosureReasonMasterDTO getClosureReasonById(int id);
    ClosureReasonMasterDTO saveClosureReason(ClosureReasonMasterDTO dto);
    void deleteClosureReason(int id);
}

