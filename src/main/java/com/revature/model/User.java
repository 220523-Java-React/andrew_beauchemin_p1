package com.revature.model;



public class User {
    public enum Role{
        CUSTOMER, EMPLOYEE;
    }

    private Role role;

    public User(Role role){
        this.role = role;
    }
}
