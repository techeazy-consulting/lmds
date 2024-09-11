package com.techeazy.lmds.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String recipientAddress;
    private int itemQuantity;
    private long totalPrice;

    public  OrderDetail(){

    }

    public OrderDetail(long totalPrice, int itemQuantity, String recipientAddress) {
        this.totalPrice = totalPrice;
        this.itemQuantity = itemQuantity;
        this.recipientAddress = recipientAddress;
    }

    public long getId() {
        return id;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}
