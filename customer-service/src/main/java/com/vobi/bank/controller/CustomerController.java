package com.vobi.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vobi.bank.domain.Customer;
import com.vobi.bank.dto.CustomerDTO;
import com.vobi.bank.mapper.CustomerMapper;
import com.vobi.bank.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin("*")
@Slf4j
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) throws Exception{
		log.info("deleteById");
		
		customerService.deleteById(id);
		
	}
	
	@PutMapping
	public CustomerDTO update(@Valid @RequestBody CustomerDTO customerDTO)throws Exception{
		log.info("update");
		Customer customer=customerMapper.customerDTOToCustomer(customerDTO);
		customer=customerService.update(customer);
		customerDTO=customerMapper.customerToDTO(customer);
		return customerDTO;
	}
	
	@PostMapping
	public CustomerDTO save(@Valid @RequestBody CustomerDTO customerDTO)throws Exception{
		log.info("save");
		Customer customer=customerMapper.customerDTOToCustomer(customerDTO);
		customer=customerService.save(customer);
		customerDTO=customerMapper.customerToDTO(customer);
		return customerDTO;
	}
	
	
	@GetMapping
	public List<CustomerDTO> findAll()throws Exception{
		log.info("findAll");
		List<Customer> customers=customerService.findAll();
		List<CustomerDTO> customerDTOs=customerMapper.customersToCustomersDTOs(customers);
		return customerDTOs;
	}
	
	@GetMapping("/{id}")
	public CustomerDTO findById(@PathVariable("id") Integer id) throws Exception{
		log.info("findById");
		Optional<Customer> optionalCustomer=customerService.findById(id);
		if(optionalCustomer.isPresent()==false) {
			return null;
		}
		Customer customer=optionalCustomer.get();
		CustomerDTO customerDTO=customerMapper.customerToDTO(customer);
		
		return customerDTO;
	}
	
	
	

}
