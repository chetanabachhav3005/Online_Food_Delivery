package com.hdfc.midterm.foodapp.DTO;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

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

@Entity
public class Orders {
	@Id
    private long orderId;
    private long customerId;
    private long restaurant_id;
    private LocalDate orderDate;
    private String deliveryAddress;
    private String paymentMethod;
    private double totalAmount;
    
}


