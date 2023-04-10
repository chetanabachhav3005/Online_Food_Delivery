package com.hdfc.midterm.foodapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class OrdersDto {

    private long orderId;
    private long customerId;
    private long restaurant_id;
    private LocalDate orderDate;
    private String deliveryAddress;
    private String paymentMethod;
    private double totalAmount;
    
}


