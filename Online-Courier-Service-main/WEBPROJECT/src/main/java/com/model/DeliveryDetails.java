package com.model;

public class DeliveryDetails {
    private int deliveryId;
    private int orderId;
    private String deliveryDate;
    private String deliveryAddress;
    private String deliveryStatus;

    public DeliveryDetails(int deliveryId, int orderId, String deliveryDate, String deliveryAddress, String deliveryStatus) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.deliveryDate = deliveryDate;
        this.deliveryAddress = deliveryAddress;
        this.deliveryStatus = deliveryStatus;
    }

    // Getters
    public int getDeliveryId() {
        return deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    // Setters
    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}