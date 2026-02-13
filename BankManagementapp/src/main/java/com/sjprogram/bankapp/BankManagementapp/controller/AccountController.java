package com.sjprogram.bankapp.BankManagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogram.bankapp.BankManagementapp.entity.Account;
import com.sjprogram.bankapp.BankManagementapp.service.AccountService;

@RestController
@RequestMapping("/vgro.bank.in")
public class AccountController {

	@Autowired
	AccountService service;
	//create account
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		Account createAccount=service.createAccount(account);
		return createAccount; 
	}
	@GetMapping("/{accountNumber}")
	public Account getAccountDetailsAccountNumber(@PathVariable Long accountNumber)
	{
		
		return service.getAccountDetailsByAccountNumber(accountNumber);
		
	}
	@GetMapping("getallaccounts")
	public List<Account> getAllAccountDetails()
	{
		return service.getAllAccountDetails();
		
	}
	@PutMapping("/deposite/{accountNumber}/{amount}")
	public Account depositeMoney(@PathVariable Long accountNumber, @PathVariable Double amount)
	{
		return service.depositeMoney(accountNumber, amount);
		
	}
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount)
	{
		return service.withdrawAmount(accountNumber, amount);
		
	}
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber) {
		service.closeAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");
		
	}
	
}
