package com.spring.boot.user.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER2_ORDERS")
public class User2Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String user;
    private String items;
    private int totalPrice;
    private Date time;

    public User2Orders(String user, String items, int totalPrice, Date time) {
        this.user = user;
        this.items = items;
        this.totalPrice = totalPrice;
        this.time = time;
    }

    public User2Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
