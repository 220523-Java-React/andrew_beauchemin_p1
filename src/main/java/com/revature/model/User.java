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

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
