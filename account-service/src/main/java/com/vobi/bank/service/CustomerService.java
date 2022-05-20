package com.vobi.bank.service;

import com.vobi.bank.dto.CustomerDTO;

public interface CustomerService {
	
	public CustomerDTO findById(Integer id)throws Exception;

}
