package com.vobi.bank.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vobi.bank.dto.CustomerDTO;

//Llamado Directo
//@FeignClient(url = "http://localhost:9092", value = "customer-feign-client", path = "/api/v1/customers")
//Eureka
//@FeignClient( value = "customer-service", path = "/api/v1/customers")
//Api-gateway
@FeignClient( value = "api-gateway", path = "customer-service/api/v1/customers")
public interface CustomerFeignClient {
	
	@GetMapping("/{id}")
	public CustomerDTO findById(@PathVariable("id") Integer id)throws Exception;

}
