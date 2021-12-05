package com.spring.boot.admin.service.controller;

import com.spring.boot.admin.service.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surabi-restaurant/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/last-one-day-bill")
    public String lastOneDayBill() {
        return adminService.getLastOneDayBill();
    }

    @GetMapping("/last-one-month-bill")
    public String lastOneMonthBill() {
        return adminService.getLastOneMonthBill();
    }
}
