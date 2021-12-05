package com.spring.boot.user.service.dto;

import java.util.Date;

public class AuditDTO {

    public AuditDTO(String user, String items, String city, int totalPrice, Date time) {
        this.user = user;
        this.items = items;
        this.city = city;
        this.totalPrice = totalPrice;
        this.time = time;
    }

    private String user;
    private String items;
    private String city;
    private int totalPrice;
    private Date time;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
