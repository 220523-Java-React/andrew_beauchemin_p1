package com.revature.model;

public enum Role {
    CUSTOMER("CUSTOMER"),
    EMPLOYEE("EMPLOYEE");

    public final String value;

    public String getValue() {
        return value;
    }
    Role(String value){ this.value = value; }
}
