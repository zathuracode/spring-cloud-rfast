package com.vobi.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vobi.bank.dto.CustomerDTO;
import com.vobi.bank.feignclient.CustomerFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerFeignClient customerFeignClient;

	@Override
	@CircuitBreaker(name = "customerService", fallbackMethod ="fallbackMethodFindById" )
	public CustomerDTO findById(Integer id) throws Exception {
		log.info("Call customerFeignClient:"+id);
		return customerFeignClient.findById(id);
	}
	
	public CustomerDTO fallbackMethodFindById(Integer id,Throwable throwable) throws Exception{
		log.error("Error en fallbackMethodFindById:"+throwable);
		return new CustomerDTO();
	}

}
