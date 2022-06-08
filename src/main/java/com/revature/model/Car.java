package com.revature.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Car implements Serializable {
    private String type;
    private Integer id;
    private Integer ownerId;
    private List<Integer> offerId;

    Car(String type){
        this.type = type;
    }

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getOwnerId() {return ownerId;}

    public void setOwnerId(Integer ownerId) {this.ownerId = ownerId;}

    public List<Integer> getOfferId() {return offerId;}

    public void setOfferId(List<Integer> offerId) {this.offerId = offerId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(type, car.type) && Objects.equals(id, car.id) && Objects.equals(ownerId, car.ownerId) && Objects.equals(offerId, car.offerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, ownerId, offerId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", ownerId=" + ownerId +
                ", offerId=" + offerId +
                '}';
    }
}
