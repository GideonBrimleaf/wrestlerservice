package com.codeclan.example.wrestlerservice.models;

public class Injury {
    private Boolean status;

    public Injury(Boolean status) {
        this.status = status;
    }

    public Injury() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
