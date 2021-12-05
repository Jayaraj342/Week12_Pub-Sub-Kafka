package com.spring.boot.admin.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    RestTemplate restTemplate;

    public String getLastOneDayBill() {
        String url = "http://localhost:8888/surabi-restaurant/last-one-day-bill";
        return restTemplate.getForObject(url, String.class);
    }

    public String getLastOneMonthBill() {
        String url = "http://localhost:8888/surabi-restaurant/last-one-month-bill";
        return restTemplate.getForObject(url, String.class);
    }
}
