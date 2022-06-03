package com.revature.model;

public class Offer {
    public enum Status{
        OPEN, APPROVED, REJECTED;
    }

    private Status status;

    Offer(Offer.Status status){
        this.status = status;
    }
}
