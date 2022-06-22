package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

public class Offer implements Serializable {

    private Status status;
    private float amount;
    private Integer customerId;
    private Integer id;

    Offer(){}

    Offer(Status status, float amount){
        this.status = status;
        this.amount = amount;
    }

    public Status getStatus() {return status;}

    public void setStatus(Status status) {this.status = status;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount;}

    public Integer getCustomerId() {return customerId;}

    public void setCustomerId(Integer customerId) {this.customerId = customerId;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    @Override
    public String toString() {
        return "Offer{" +
                "status=" + status +
                ", amount=" + amount +
                ", customerId=" + customerId +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Float.compare(offer.amount, amount) == 0 && status == offer.status && Objects.equals(customerId, offer.customerId) && Objects.equals(id, offer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, amount, customerId, id);
    }
}
