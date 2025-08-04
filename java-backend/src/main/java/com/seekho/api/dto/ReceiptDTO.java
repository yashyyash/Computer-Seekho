//package com.seekho.api.dto;
//
//import java.time.LocalDate;
//
//public class ReceiptDTO {
//
//    private int receiptId;
//    private LocalDate receiptDate;
//    private double receiptAmount;
//    private int paymentId;
//
//    // Getters and Setters
//
//    public int getReceiptId() {
//        return receiptId;
//    }
//
//    public void setReceiptId(int receiptId) {
//        this.receiptId = receiptId;
//    }
//
//    public LocalDate getReceiptDate() {
//        return receiptDate;
//    }
//
//    public void setReceiptDate(LocalDate receiptDate) {
//        this.receiptDate = receiptDate;
//    }
//
//    public double getReceiptAmount() {
//        return receiptAmount;
//    }
//
//    public void setReceiptAmount(double receiptAmount) {
//        this.receiptAmount = receiptAmount;
//    }
//
//    public int getPaymentId() {
//        return paymentId;
//    }
//
//    public void setPaymentId(int paymentId) {
//        this.paymentId = paymentId;
//    }
//}



package com.seekho.api.dto;

import java.time.LocalDate;

public class ReceiptDTO {

    private Long receipt_id;
    private LocalDate receipt_date;
    private Double receipt_amount;
    private Long payment_id;

    // Getters and Setters

    public Long getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(Long receipt_id) {
        this.receipt_id = receipt_id;
    }

    public LocalDate getReceipt_date() {
        return receipt_date;
    }

    public void setReceipt_date(LocalDate receipt_date) {
        this.receipt_date = receipt_date;
    }

    public Double getReceipt_amount() {
        return receipt_amount;
    }

    public void setReceipt_amount(Double receipt_amount) {
        this.receipt_amount = receipt_amount;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }
}
