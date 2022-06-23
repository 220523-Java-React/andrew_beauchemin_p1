package com.revature.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Car implements Serializable {
    private String model;
    private Integer id;
    private Integer ownerId;
    private String vinNumber;

    public Car(){}

    public Car(String type){
        this.model = type;
    }

    public Integer getId() {return id;}

    public Car setId(Integer id) {this.id = id; return this;}

    public Integer getOwnerId() {return ownerId;}

    public Car setOwnerId(Integer ownerId) {this.ownerId = ownerId;return this;}

    public String getModel() {return model;}

    public Car setModel(String model) {this.model = model;return this;}

    public String getVinNumber() {return vinNumber;}

    public Car setVinNumber(String vinNumber) {this.vinNumber = vinNumber;return this;}

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
