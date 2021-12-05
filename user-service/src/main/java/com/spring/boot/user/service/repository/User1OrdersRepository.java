package com.spring.boot.user.service.repository;

import com.spring.boot.user.service.entity.User1Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User1OrdersRepository extends JpaRepository<User1Orders, Integer> {
}
