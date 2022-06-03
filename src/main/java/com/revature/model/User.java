package com.revature.model;



public class User {
    public enum Role{
        CUSTOMER, EMPLOYEE;
    }

    private Role role;
    private String username;

    public User(Role role, String username){
        this.role = role;
        this.username = username;
    }
}
