package com.spring.boot.admin.service.controller;

import com.spring.boot.admin.service.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surabi-restaurant/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders-in-different-cities")
    public String orders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/max-sales")
    public String maxSales() {
        return orderService.maxSales();
    }

    @GetMapping("/all-sales-last-year")
    public String allSalesLastYear() {
        return orderService.allSalesLastYear();
    }
}
