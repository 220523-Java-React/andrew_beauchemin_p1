package com.revature.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Car implements Serializable {
    private String model;
    private Integer id;
    private Integer ownerId;
    private String vinNumber;

    Car(){}

    Car(String type){
        this.model = type;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getOwnerId() {return ownerId;}

    public void setOwnerId(Integer ownerId) {this.ownerId = ownerId;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public String getVinNumber() {return vinNumber;}

    public void setVinNumber(String vinNumber) {this.vinNumber = vinNumber;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(id, car.id) && Objects.equals(ownerId, car.ownerId) && Objects.equals(vinNumber, car.vinNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, id, ownerId, vinNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", id=" + id +
                ", ownerId=" + ownerId +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }
}
