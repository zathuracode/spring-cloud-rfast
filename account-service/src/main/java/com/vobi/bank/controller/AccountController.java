package com.vobi.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vobi.bank.dto.AccountDTO;
import com.vobi.bank.service.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/{id}")
	public AccountDTO findById(@PathVariable("id") String id)throws Exception{
		if(accountService.findById(id).isPresent()==false) {
			return null;
		}
		
		AccountDTO accountDTO=accountService.findById(id).get();
		
		return accountDTO;
	}
	

}
