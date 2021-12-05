package com.spring.boot.user.service.config;

import com.spring.boot.user.service.dto.AuditDTO;
import com.spring.boot.user.service.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

@Aspect
@Configuration
public class AuditLogConfiguration {

    private final UserService userService;

    public AuditLogConfiguration(UserService userService) {
        this.userService = userService;
    }

    @AfterReturning(value = "execution(* com.spring.boot.user.service.controller.UserController.selectMenuWithBill(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, String result) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String[] itemsWithTotal = result.split("selected &");
        String items = itemsWithTotal[0].trim();
        String total = itemsWithTotal[1].replace("Final bill is ₹", "").trim();
        String username = user.getUsername();
        userService.addLogToAudit(
                new AuditDTO(
                        username,
                        items,
                        username.equals("user1") ? "Bangalore" : "Chennai",
                        Integer.parseInt(total), new Date()
                )
        );
    }
}
