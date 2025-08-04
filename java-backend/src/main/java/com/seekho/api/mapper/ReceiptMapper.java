//package com.seekho.api.mapper;
//
//import com.seekho.api.dto.ReceiptDTO;
//import com.seekho.api.entity.Receipt;
//
//public class ReceiptMapper {
//
//    public static ReceiptDTO toDTO(Receipt receipt) {
//        if (receipt == null) return null;
//
//        ReceiptDTO dto = new ReceiptDTO();
//        dto.setReceiptId(receipt.getReceiptId());
//        dto.setReceiptDate(receipt.getReceiptDate());
//        dto.setReceiptAmount(receipt.getReceiptAmount());
//        dto.setPaymentId(receipt.getPaymentId());
//        return dto;
//    }
//
//    public static Receipt toEntity(ReceiptDTO dto) {
//        if (dto == null) return null;
//
//        Receipt receipt = new Receipt();
//        receipt.setReceiptId(dto.getReceiptId());
//        receipt.setReceiptDate(dto.getReceiptDate());
//        receipt.setReceiptAmount(dto.getReceiptAmount());
//        receipt.setPaymentId(dto.getPaymentId());
//        return receipt;
//    }
//}



package com.seekho.api.mapper;

import com.seekho.api.dto.ReceiptDTO;
import com.seekho.api.entity.Receipt;

public class ReceiptMapper {

    public static ReceiptDTO toDTO(Receipt entity) {
        ReceiptDTO dto = new ReceiptDTO();
        dto.setReceipt_id(entity.getReceipt_id());
        dto.setReceipt_date(entity.getReceipt_date());
        dto.setReceipt_amount(entity.getReceipt_amount());
        dto.setPayment_id(entity.getPayment_id());
        return dto;
    }

    public static Receipt toEntity(ReceiptDTO dto) {
        Receipt entity = new Receipt();
        entity.setReceipt_id(dto.getReceipt_id());
        entity.setReceipt_date(dto.getReceipt_date());
        entity.setReceipt_amount(dto.getReceipt_amount());
        entity.setPayment_id(dto.getPayment_id());
        return entity;
    }
}
