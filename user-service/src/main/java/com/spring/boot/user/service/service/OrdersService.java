package com.spring.boot.user.service.service;

import com.spring.boot.user.service.dto.DateFilter;
import com.spring.boot.user.service.dto.PriceFilter;
import com.spring.boot.user.service.entity.User1Orders;
import com.spring.boot.user.service.entity.User2Orders;
import com.spring.boot.user.service.repository.User1OrdersRepository;
import com.spring.boot.user.service.repository.Users2OrdersRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.spring.boot.user.service.service.UserService.getStartOfToday;

@Service
public class OrdersService {

    private final User1OrdersRepository user1OrdersRepository;
    private final Users2OrdersRepository users2OrdersRepository;

    public OrdersService(User1OrdersRepository user1OrdersRepository, Users2OrdersRepository users2OrdersRepository) {
        this.user1OrdersRepository = user1OrdersRepository;
        this.users2OrdersRepository = users2OrdersRepository;
    }

    public String getAllMyOrders() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();

        StringBuilder result = new StringBuilder();
        if (userName.equals("user1")) {
            List<User1Orders> user1Orders = user1OrdersRepository.findAll();
            if (user1Orders.isEmpty()) {
                return "No orders!";
            }
            for (User1Orders user1Order : user1Orders) {
                result
                        .append("Items -> ")
                        .append(user1Order.getItems())
                        .append("& Total price -> ")
                        .append(user1Order.getTotalPrice())
                        .append("\n");
            }
        } else {
            List<User2Orders> user2Orders = users2OrdersRepository.findAll();
            if (user2Orders.isEmpty()) {
                return "No orders!";
            }
            for (User2Orders user2Order : user2Orders) {
                result
                        .append("Items -> ")
                        .append(user2Order.getItems())
                        .append("& Total price -> ")
                        .append(user2Order.getTotalPrice())
                        .append("\n");
            }
        }

        return result.toString();
    }

    public String filterOrders(DateFilter dateFilter, PriceFilter priceFilter) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();

        StringBuilder result = new StringBuilder();
        if (userName.equals("user1")) {
            List<User1Orders> user1Orders = user1OrdersRepository.findAll();

            user1Orders = filterUser1Orders(dateFilter, priceFilter, user1Orders);

            if (user1Orders.isEmpty()) {
                return "No orders!";
            }
            user1Orders.forEach(
                    order -> result
                            .append("Items -> ")
                            .append(order.getItems())
                            .append("& Total price -> ")
                            .append(order.getTotalPrice())
                            .append("\n")
            );
        } else {
            List<User2Orders> user2Orders = users2OrdersRepository.findAll();

            user2Orders = filterUser2Orders(dateFilter, priceFilter, user2Orders);

            if (user2Orders.isEmpty()) {
                return "No orders!";
            }
            for (User2Orders user2Order : user2Orders) {
                result
                        .append("Items -> ")
                        .append(user2Order.getItems())
                        .append("& Total price -> ")
                        .append(user2Order.getTotalPrice())
                        .append("\n");
            }
        }

        return result.toString();
    }

    private List<User2Orders> filterUser2Orders(DateFilter dateFilter, PriceFilter priceFilter, List<User2Orders> user2Orders) {
        user2Orders = user2Orders.stream().filter(
                order -> {
                    Date orderTime = order.getTime();
                    Calendar lastYearToday = getStartOfToday();
                    lastYearToday.add(Calendar.DATE, -365);

                    if (dateFilter.equals(DateFilter.LAST_YEAR)) {
                        return orderTime.after(lastYearToday.getTime());
                    } else {
                        return orderTime.before(lastYearToday.getTime());
                    }
                }
        ).collect(Collectors.toList());

        user2Orders = user2Orders.stream().filter(
                order -> {
                    int totalPrice = order.getTotalPrice();
                    Calendar lastYearToday = getStartOfToday();
                    lastYearToday.add(Calendar.DATE, -365);

                    if (priceFilter.equals(PriceFilter.GREATER_THAN_FIFTY)) {
                        return totalPrice > 50;
                    } else {
                        return totalPrice <= 50;
                    }
                }
        ).collect(Collectors.toList());
        return user2Orders;
    }

    private List<User1Orders> filterUser1Orders(DateFilter dateFilter, PriceFilter priceFilter, List<User1Orders> user1Orders) {
        user1Orders = user1Orders.stream().filter(
                order -> {
                    Date orderTime = order.getTime();
                    Calendar lastYearToday = getStartOfToday();
                    lastYearToday.add(Calendar.DATE, -365);

                    if (dateFilter.equals(DateFilter.LAST_YEAR)) {
                        return orderTime.after(lastYearToday.getTime());
                    } else {
                        return orderTime.before(lastYearToday.getTime());
                    }
                }
        ).collect(Collectors.toList());

        user1Orders = user1Orders.stream().filter(
                order -> {
                    int totalPrice = order.getTotalPrice();
                    Calendar lastYearToday = getStartOfToday();
                    lastYearToday.add(Calendar.DATE, -365);

                    if (priceFilter.equals(PriceFilter.GREATER_THAN_FIFTY)) {
                        return totalPrice > 50;
                    } else {
                        return totalPrice <= 50;
                    }
                }
        ).collect(Collectors.toList());
        return user1Orders;
    }
}
