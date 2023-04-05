package com.hdfc.midterm.foodapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

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
    private long order_id;
    private long customer_id;
    private long restaurant_id;
    private LocalDate order_date;
    private String delivery_address;
    private String payment_method;
    private double total_amount;
    
}


