//package com.seekho.api.dto;
//
//public class PaymentTypeMasterDTO {
//
//    private int paymentTypeId;
//    private String paymentTypeDesc;
//
//    // Getters and Setters
//
//    public int getPaymentTypeId() {
//        return paymentTypeId;
//    }
//
//    public void setPaymentTypeId(int paymentTypeId) {
//        this.paymentTypeId = paymentTypeId;
//    }
//
//    public String getPaymentTypeDesc() {
//        return paymentTypeDesc;
//    }
//
//    public void setPaymentTypeDesc(String paymentTypeDesc) {
//        this.paymentTypeDesc = paymentTypeDesc;
//    }
//}



package com.seekho.api.dto;

public class PaymentTypeMasterDTO {

    private Long payment_type_id;
    private String payment_type_desc;

    // Getters and Setters
    public Long getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(Long payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getPayment_type_desc() {
        return payment_type_desc;
    }

    public void setPayment_type_desc(String payment_type_desc) {
        this.payment_type_desc = payment_type_desc;
    }
}
