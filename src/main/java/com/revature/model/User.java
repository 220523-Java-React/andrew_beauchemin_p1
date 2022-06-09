package com.revature.model;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {


    private Role role;
    private String username;
    private Integer id;
    private List<Integer> carsOwnedId;
    private List<Integer> offersMadeId;

    // need default constructor for json to class
    public User(){}
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getCarsOwnedId() {
        return carsOwnedId;
    }

    public void setCarsOwnedId(List<Integer> carsOwned) {
        this.carsOwnedId = carsOwned;
    }

    public List<Integer> getOffersMadeId() {
        return offersMadeId;
    }

    public void setOffersMadeId(List<Integer> offersMade) {
        this.offersMadeId = offersMade;
    }

    public void addCarId(Integer car){carsOwnedId.add(car);}

    public void addOfferId(Integer offer){offersMadeId.add(offer);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return role == user.role && Objects.equals(username, user.username) && Objects.equals(id, user.id) && Objects.equals(carsOwnedId, user.carsOwnedId) && Objects.equals(offersMadeId, user.offersMadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, username, id, carsOwnedId, offersMadeId);
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", username='" + username + '\'' +
                ", id=" + id +
                ", carsOwned=" + carsOwnedId +
                ", offersMade=" + offersMadeId +
                '}';
    }
}
