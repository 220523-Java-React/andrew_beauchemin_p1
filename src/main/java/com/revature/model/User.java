package com.revature.model;


import java.util.List;

public class User {
    public enum Role{
        CUSTOMER, EMPLOYEE;
    }

    private Role role;
    private String username;
    private Integer id;
    private List<Car> carsOwned;
    private List<Offer> OffersMade;

    // need default constructor for json to class
    public User(){}
    public User(Role role, String username, Integer id){
        this.role = role;
        this.username = username;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
