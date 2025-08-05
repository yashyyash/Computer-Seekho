package com.seekho.api.dto;

public class ClosureReasonMasterDTO {

    private int closure_id;
    private String closure_reason_desc;

    // Getters and Setters

    public int getClosure_id() {
        return closure_id;
    }

    public void setClosure_id(int closure_id) {
        this.closure_id = closure_id;
    }

    public String getClosure_reason_desc() {
        return closure_reason_desc;
    }

    public void setClosure_reason_desc(String closure_reason_desc) {
        this.closure_reason_desc = closure_reason_desc;
    }
}
