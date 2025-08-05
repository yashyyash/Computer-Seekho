package com.seekho.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "closure_reason_master")
public class ClosureReasonMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "closure_id")
    private int closureId;

    @Column(name = "closure_reason_desc")
    private String closureReasonDesc;

    // Getters and Setters

    public int getClosureId() {
        return closureId;
    }

    public void setClosureId(int closureId) {
        this.closureId = closureId;
    }

    public String getClosureReasonDesc() {
        return closureReasonDesc;
    }

    public void setClosureReasonDesc(String closureReasonDesc) {
        this.closureReasonDesc = closureReasonDesc;
    }
}
