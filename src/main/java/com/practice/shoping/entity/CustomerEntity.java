package com.practice.shoping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<OrdersEntity> orders;

}
