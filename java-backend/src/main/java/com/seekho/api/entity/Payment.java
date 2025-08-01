package com.seekho.api.entity;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class Payment {

    @Id
    private int payment_id;
    private int payment_type_id;
    private LocalDate payment_date;
    private int student_id;
    private int course_id;
    private int batch_id;
    private int amount;

}
