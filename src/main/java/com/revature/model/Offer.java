package com.revature.model;

public class Offer {
    public enum Status{
        OPEN, APPROVED, REJECTED;
    }

    private Status status;
    private float amount;

    Offer(Offer.Status status, float amount){
        this.status = status;
        this.amount = amount;
    }
}
