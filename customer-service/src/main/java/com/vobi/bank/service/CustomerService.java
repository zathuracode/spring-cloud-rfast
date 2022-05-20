package com.vobi.bank.service;

import java.util.List;
import java.util.Optional;

import com.vobi.bank.domain.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	
	Optional<Customer> findById(Integer id);
	
	Customer save(Customer customer)throws Exception;
	
	Customer update(Customer customer)throws Exception;
	
	void delete(Customer customer)throws Exception;
	
	void deleteById(Integer id)throws Exception;
	
	void validate(Customer customer)throws Exception;
	
	Long count();	

}
