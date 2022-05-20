package com.vobi.bank.service;

import java.util.Optional;

import com.vobi.bank.dto.AccountDTO;

public interface AccountService {

	Optional<AccountDTO> findById(String id)throws Exception;

}
