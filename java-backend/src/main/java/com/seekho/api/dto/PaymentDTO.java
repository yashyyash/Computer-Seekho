//package com.seekho.api.dto;
//
//import java.time.LocalDate;
//
//public class PaymentDTO {
//
//    private int paymentId;
//    private int paymentTypeId;
//    private LocalDate paymentDate;
//    private int studentId;
//    private int courseId;
//    private int batchId;
//    private int amount;
//
//    // Getters and Setters
//
//    public int getPaymentId() {
//        return paymentId;
//    }
//
//    public void setPaymentId(int paymentId) {
//        this.paymentId = paymentId;
//    }
//
//    public int getPaymentTypeId() {
//        return paymentTypeId;
//    }
//
//    public void setPaymentTypeId(int paymentTypeId) {
//        this.paymentTypeId = paymentTypeId;
//    }
//
//    public LocalDate getPaymentDate() {
//        return paymentDate;
//    }
//
//    public void setPaymentDate(LocalDate paymentDate) {
//        this.paymentDate = paymentDate;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public int getBatchId() {
//        return batchId;
//    }
//
//    public void setBatchId(int batchId) {
//        this.batchId = batchId;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//}


package com.seekho.api.dto;

import java.time.LocalDate;

public class PaymentDTO {

    private Long payment_id;
    private Long payment_type_id;
    private LocalDate payment_date;
    private Long student_id;
    private Long course_id;
    private Long batch_id;
    private Double amount;

    // Getters and Setters

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(Long payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Long batch_id) {
        this.batch_id = batch_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
