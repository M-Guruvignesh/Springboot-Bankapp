package com.sjprogram.bankapp.BankManagementapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogram.bankapp.BankManagementapp.entity.Account;
import com.sjprogram.bankapp.BankManagementapp.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository repo;
	@Override
	public Account createAccount(Account account) {
		
		return repo.save(account);
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account Not Present");
		}
		Account account_found=account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		
		return repo.findAll();
	}

	@Override
	public Account depositeMoney(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()){
			throw new RuntimeException("Account Not Present");
		}
		Account present_account=account.get();
		Double total_balance=present_account.getAccount_balance()+amount;
		present_account.setAccount_balance(total_balance);
		repo.save(present_account);
		return present_account;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()){
			throw new RuntimeException("Account Not Present");
		}
		Account present_account=account.get();
		Double total_balance=present_account.getAccount_balance()-amount;
		present_account.setAccount_balance(total_balance);
		repo.save(present_account);
		return present_account;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
	}

}
