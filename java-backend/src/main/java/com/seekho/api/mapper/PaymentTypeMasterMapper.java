//package com.seekho.api.mapper;
//
//import com.seekho.api.dto.PaymentTypeMasterDTO;
//import com.seekho.api.entity.PaymentTypeMaster;
//
//public class PaymentTypeMasterMapper {
//
//    public static PaymentTypeMasterDTO toDTO(PaymentTypeMaster entity) {
//        if (entity == null) return null;
//
//        PaymentTypeMasterDTO dto = new PaymentTypeMasterDTO();
//        dto.setPaymentTypeId(entity.getPaymentTypeId());
//        dto.setPaymentTypeDesc(entity.getPaymentTypeDesc());
//        return dto;
//    }
//
//    public static PaymentTypeMaster toEntity(PaymentTypeMasterDTO dto) {
//        if (dto == null) return null;
//
//        PaymentTypeMaster entity = new PaymentTypeMaster();
//        entity.setPaymentTypeId(dto.getPaymentTypeId());
//        entity.setPaymentTypeDesc(dto.getPaymentTypeDesc());
//        return entity;
//    }
//}



package com.seekho.api.mapper;

import com.seekho.api.dto.PaymentTypeMasterDTO;
import com.seekho.api.entity.PaymentTypeMaster;

public class PaymentTypeMasterMapper {

    public static PaymentTypeMasterDTO toDTO(PaymentTypeMaster entity) {
        PaymentTypeMasterDTO dto = new PaymentTypeMasterDTO();
        dto.setPayment_type_id(entity.getPayment_type_id());
        dto.setPayment_type_desc(entity.getPayment_type_desc());
        return dto;
    }

    public static PaymentTypeMaster toEntity(PaymentTypeMasterDTO dto) {
        PaymentTypeMaster entity = new PaymentTypeMaster();
        entity.setPayment_type_id(dto.getPayment_type_id());
        entity.setPayment_type_desc(dto.getPayment_type_desc());
        return entity;
    }
}
