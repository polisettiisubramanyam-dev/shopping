package com.practice.shoping.repository;

import com.practice.shoping.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
}
