//package com.seekho.api.mapper;
//
//import com.seekho.api.dto.PaymentDTO;
//import com.seekho.api.entity.Payment;
//
//public class PaymentMapper {
//
//    public static PaymentDTO toDTO(Payment payment) {
//        if (payment == null) return null;
//
//        PaymentDTO dto = new PaymentDTO();
//        dto.setPaymentId(payment.getPaymentId());
//        dto.setPaymentTypeId(payment.getPaymentTypeId());
//        dto.setPaymentDate(payment.getPaymentDate());
//        dto.setStudentId(payment.getStudentId());
//        dto.setCourseId(payment.getCourseId());
//        dto.setBatchId(payment.getBatchId());
//        dto.setAmount(payment.getAmount());
//        return dto;
//    }
//
//    public static Payment toEntity(PaymentDTO dto) {
//        if (dto == null) return null;
//
//        Payment payment = new Payment();
//        payment.setPaymentId(dto.getPaymentId());
//        payment.setPaymentTypeId(dto.getPaymentTypeId());
//        payment.setPaymentDate(dto.getPaymentDate());
//        payment.setStudentId(dto.getStudentId());
//        payment.setCourseId(dto.getCourseId());
//        payment.setBatchId(dto.getBatchId());
//        payment.setAmount(dto.getAmount());
//        return payment;
//    }
//}


package com.seekho.api.mapper;

import com.seekho.api.dto.PaymentDTO;
import com.seekho.api.entity.Payment;

public class PaymentMapper {

    public static PaymentDTO toDTO(Payment entity) {
        PaymentDTO dto = new PaymentDTO();
        dto.setPayment_id(entity.getPayment_id());
        dto.setPayment_type_id(entity.getPayment_type_id());
        dto.setPayment_date(entity.getPayment_date());
        dto.setStudent_id(entity.getStudent_id());
        dto.setCourse_id(entity.getCourse_id());
        dto.setBatch_id(entity.getBatch_id());
        dto.setAmount(entity.getAmount());
        return dto;
    }

    public static Payment toEntity(PaymentDTO dto) {
        Payment entity = new Payment();
        entity.setPayment_id(dto.getPayment_id());
        entity.setPayment_type_id(dto.getPayment_type_id());
        entity.setPayment_date(dto.getPayment_date());
        entity.setStudent_id(dto.getStudent_id());
        entity.setCourse_id(dto.getCourse_id());
        entity.setBatch_id(dto.getBatch_id());
        entity.setAmount(dto.getAmount());
        return entity;
    }
}

