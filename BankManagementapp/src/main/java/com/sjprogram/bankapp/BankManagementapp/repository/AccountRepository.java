package com.sjprogram.bankapp.BankManagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogram.bankapp.BankManagementapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
