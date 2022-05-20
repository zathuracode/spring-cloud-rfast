package com.vobi.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vobi.bank.domain.Customer;
import com.vobi.bank.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {
	
	@Mapping(source = "documentType.dotyId", target = "dotyId")
	public CustomerDTO customerToDTO(Customer customer);
	
	@Mapping(target = "documentType.dotyId", source = "dotyId")
	public Customer customerDTOToCustomer(CustomerDTO customerDTO);
	
	public List<CustomerDTO> customersToCustomersDTOs(List<Customer> customers);
	
	public List<Customer> customersDTOsToCustomers(List<CustomerDTO> customerDTOs);

}
