package com.spring.boot.user.service.repository;

import com.spring.boot.user.service.entity.User2Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users2OrdersRepository extends JpaRepository<User2Orders, Integer> {
}
