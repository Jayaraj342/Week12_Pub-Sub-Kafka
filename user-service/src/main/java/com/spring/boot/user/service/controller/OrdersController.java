package com.spring.boot.user.service.controller;

import com.spring.boot.user.service.dto.DateFilter;
import com.spring.boot.user.service.dto.PriceFilter;
import com.spring.boot.user.service.service.OrdersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surabi-restaurant/order")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/view-orders")
    public String viewMenu() {
        return ordersService.getAllMyOrders();
    }

    @GetMapping("/orders-with-filters")
    public String ordersWithFilters(
            @RequestParam(defaultValue = "THIS_YEAR") DateFilter dateFilter,
            @RequestParam(defaultValue = "NOT_GREATER_THAN_FIFTY") PriceFilter priceFilter
    ) {
        return ordersService.filterOrders(dateFilter, priceFilter);
    }
}
