package com.spring.boot.admin.service.repository;

import com.spring.boot.admin.service.entity.MaxSalesInLastMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxSalesInLastMonthRepository extends JpaRepository<MaxSalesInLastMonth, Integer> {
}
