package com.revature.model;

public enum Status {
    OPEN("OPEN"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    public final String value;

    Status(String value){ this.value = value; }

}
