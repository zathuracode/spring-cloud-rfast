package com.vobi.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	
	private String accoId;

	private CustomerDTO customer;
	
	private Double balance;
	
	private String enable;

	private String password;
	
	private Long version;

}
