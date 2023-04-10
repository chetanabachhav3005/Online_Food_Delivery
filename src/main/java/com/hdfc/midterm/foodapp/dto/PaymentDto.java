package com.hdfc.midterm.foodapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString



public class PaymentDto {
	private Integer paymentId;
	private LocalDateTime paymentDate;
	private Double totalCost;
	private Integer totalItem;
	

	private long cardId;
	private long amount;
	private int code;
	
	
}
