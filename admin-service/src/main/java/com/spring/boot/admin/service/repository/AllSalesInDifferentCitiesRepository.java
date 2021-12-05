package com.spring.boot.admin.service.repository;

import com.spring.boot.admin.service.entity.AllSalesInDifferentCities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllSalesInDifferentCitiesRepository extends JpaRepository<AllSalesInDifferentCities, Integer> {
}
