package com.spring.boot.admin.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAX_SALES_IN_LAST_MONTH")
public class MaxSalesInLastMonth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String user;
    private String items;
    private String city;
    private int totalPrice;
    private Date time;

    public MaxSalesInLastMonth(String user, String items, String city, int totalPrice, Date time) {
        this.user = user;
        this.items = items;
        this.city = city;
        this.totalPrice = totalPrice;
        this.time = time;
    }

    public MaxSalesInLastMonth() {
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
