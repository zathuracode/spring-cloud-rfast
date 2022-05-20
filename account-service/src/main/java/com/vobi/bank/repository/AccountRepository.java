package com.vobi.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vobi.bank.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
