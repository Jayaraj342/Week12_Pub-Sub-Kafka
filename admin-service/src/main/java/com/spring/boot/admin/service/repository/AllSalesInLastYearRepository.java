package com.spring.boot.admin.service.repository;

import com.spring.boot.admin.service.entity.AllSalesInLastYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllSalesInLastYearRepository extends JpaRepository<AllSalesInLastYear, Integer> {
}
