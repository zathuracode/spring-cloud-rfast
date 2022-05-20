package com.vobi.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vobi.bank.domain.Account;
import com.vobi.bank.dto.AccountDTO;
import com.vobi.bank.dto.CustomerDTO;
import com.vobi.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerService customerService;

	@Override
	@Transactional(readOnly = true)
	public Optional<AccountDTO> findById(String id)throws Exception {
		
		if(accountRepository.findById(id).isPresent()==false)
			return Optional.empty();
		
		Account account=accountRepository.findById(id).get();
		//TODO llnear el customer DTO con el servicio
		
		AccountDTO accountDTO=new AccountDTO();
		accountDTO.setAccoId(account.getAccoId());
		accountDTO.setBalance(account.getBalance());
		accountDTO.setEnable(account.getEnable());
		accountDTO.setPassword(account.getPassword());
		accountDTO.setVersion(account.getVersion());
		
		//Llamo a el servicio
		CustomerDTO customerDTO=customerService.findById(account.getCustId());
		accountDTO.setCustomer(customerDTO);
		
		return Optional.of(accountDTO);
	}
	


}
