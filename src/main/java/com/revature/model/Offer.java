package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

public class Offer implements Serializable {

    private Status status;
    private float amount;
    private Integer customerId;
    private Integer carID;
    private Integer id;

    public Offer(){}

    public Offer(Status status, float amount){
        this.status = status;
        this.amount = amount;
    }

    public Status getStatus() {return status;}

    public Offer setStatus(Status status) {this.status = status;return this;}

    public float getAmount() {return amount;}

    public Offer setAmount(float amount) {this.amount = amount;return this;}

    public Integer getCustomerId() {return customerId;}

    public Offer setCustomerId(Integer customerId) {this.customerId = customerId;return this;}

    public Integer getId() {return id;}

    public Offer setId(Integer id) {this.id = id;return this;}

    public Integer getCarID() {return carID;}

    public Offer setCarID(Integer carID) {this.carID = carID;return this;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Float.compare(offer.amount, amount) == 0 && status == offer.status && Objects.equals(customerId, offer.customerId) && Objects.equals(carID, offer.carID) && Objects.equals(id, offer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, amount, customerId, carID, id);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "status=" + status +
                ", amount=" + amount +
                ", customerId=" + customerId +
                ", carID=" + carID +
                ", id=" + id +
                '}';
    }
}
