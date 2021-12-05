package com.spring.boot.admin.service.service;

import com.spring.boot.admin.service.entity.AllSalesInDifferentCities;
import com.spring.boot.admin.service.entity.AllSalesInLastYear;
import com.spring.boot.admin.service.entity.MaxSalesInLastMonth;
import com.spring.boot.admin.service.repository.AllSalesInDifferentCitiesRepository;
import com.spring.boot.admin.service.repository.AllSalesInLastYearRepository;
import com.spring.boot.admin.service.repository.MaxSalesInLastMonthRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final AllSalesInDifferentCitiesRepository allSalesInDifferentCitiesRepository;
    private final MaxSalesInLastMonthRepository maxSalesInLastMonthRepository;
    private final AllSalesInLastYearRepository allSalesInLastYearRepository;

    public OrderService(AllSalesInDifferentCitiesRepository allSalesInDifferentCitiesRepository, MaxSalesInLastMonthRepository maxSalesInLastMonthRepository, AllSalesInLastYearRepository allSalesInLastYearRepository) {
        this.allSalesInDifferentCitiesRepository = allSalesInDifferentCitiesRepository;
        this.maxSalesInLastMonthRepository = maxSalesInLastMonthRepository;
        this.allSalesInLastYearRepository = allSalesInLastYearRepository;
    }

    public String getAllOrders() {
        List<AllSalesInDifferentCities> allSalesInDifferentCities = allSalesInDifferentCitiesRepository.findAll();

        StringBuilder result = new StringBuilder();
        allSalesInDifferentCities.forEach(
                order -> result
                        .append("Items -> ")
                        .append(order.getItems())
                        .append("& Total price -> ")
                        .append(order.getTotalPrice())
                        .append("\n")
        );

        return result.toString();
    }

    public String maxSales() {
        List<MaxSalesInLastMonth> maxSalesInLastMonths = maxSalesInLastMonthRepository.findAll();

        StringBuilder result = new StringBuilder();
        maxSalesInLastMonths.forEach(
                order -> result
                        .append("Items -> ")
                        .append(order.getItems())
                        .append("& Total price -> ")
                        .append(order.getTotalPrice())
                        .append("\n")
        );

        return result.toString();
    }

    public String allSalesLastYear() {
        List<AllSalesInLastYear> allSalesInLastYears = allSalesInLastYearRepository.findAll();

        StringBuilder result = new StringBuilder();
        allSalesInLastYears.forEach(
                order -> result
                        .append("Items -> ")
                        .append(order.getItems())
                        .append("& Total price -> ")
                        .append(order.getTotalPrice())
                        .append("\n")
        );

        return result.toString();
    }
}
