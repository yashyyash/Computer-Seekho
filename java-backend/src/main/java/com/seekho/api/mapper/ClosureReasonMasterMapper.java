package com.seekho.api.mapper;

import com.seekho.api.dto.ClosureReasonMasterDTO;
import com.seekho.api.entity.ClosureReasonMaster;

public class ClosureReasonMasterMapper {

    public ClosureReasonMasterDTO toDTO(ClosureReasonMaster entity) {
        ClosureReasonMasterDTO dto = new ClosureReasonMasterDTO();

        dto.setClosure_id(entity.getClosureId());
        dto.setClosure_reason_desc(entity.getClosureReasonDesc());

        return dto;
    }

    public ClosureReasonMaster toEntity(ClosureReasonMasterDTO dto) {
        ClosureReasonMaster entity = new ClosureReasonMaster();

        entity.setClosureId(dto.getClosure_id());
        entity.setClosureReasonDesc(dto.getClosure_reason_desc());

        return entity;
    }
}
