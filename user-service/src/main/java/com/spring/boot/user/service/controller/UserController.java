package com.spring.boot.user.service.controller;

import com.spring.boot.user.service.dto.AuditDTO;
import com.spring.boot.user.service.entity.Item;
import com.spring.boot.user.service.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surabi-restaurant/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view-menu")
    public List<Item> viewMenu() {
        return userService.getAllItems();
    }

    @GetMapping("/select-menu-with-bill")
    public String selectMenuWithBill(@RequestParam List<Integer> ids) {
        List<Item> items = userService.selectItemsWithBill(ids);
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return items + " selected & Final bill is ₹" + totalPrice;
    }

    @GetMapping("/last-bill")
    public String lastBill() {
        return userService.getLastBill();
    }

    @PostMapping("/add-log-to-audit")
    @ApiOperation(value = "", hidden = true)
    public String addLogToAudit(AuditDTO auditDTO) {
        return userService.addLogToAudit(auditDTO);
    }

    @GetMapping("/last-one-day-bill")
    @ApiOperation(value = "", hidden = true)
    public String lastOneDayBill() {
        return userService.getLastOneDayBill();
    }

    @GetMapping("/last-one-month-bill")
    @ApiOperation(value = "", hidden = true)
    public String lastOneMonthBill() {
        return userService.getLastOneMonthBill();
    }
}
