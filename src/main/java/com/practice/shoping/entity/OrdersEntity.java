package com.practice.shoping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="order_date")
    LocalDate date;

    @JoinColumn(name="customer_id")
    @ManyToOne
    @JsonIgnore
    CustomerEntity customer;

}
