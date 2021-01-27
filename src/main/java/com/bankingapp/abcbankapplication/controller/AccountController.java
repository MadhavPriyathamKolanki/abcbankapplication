package com.bankingapp.abcbankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.abcbankapplication.model.Account;
import com.bankingapp.abcbankapplication.model.FundTransfer;
import com.bankingapp.abcbankapplication.model.Transaction;
import com.bankingapp.abcbankapplication.service.AccountService;




@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	AccountService accountService;
	

	@GetMapping(value = "/getaccountsofcustomer/{customerid}")  
	public List<Account> getAccountsByCustomerId(@PathVariable("customerid") int customerId) {
		return accountService.getAccountsByCustomerId(customerId);
	}
	
	@PostMapping("/fundtransfer")   // TO TRANSFER MONEY FROM AN ACCOUNT TO ANOTHER ACCOUNT
	public Transaction transfer(@RequestBody FundTransfer fundtransfer) {
		System.out.println(fundtransfer.getFromaccountnumber());
		System.out.println(fundtransfer.getToaccountnumber());
		System.out.println(fundtransfer.getTransactionamount());
		return accountService.transferamount(fundtransfer);
	}
	
	@PostMapping(value = "/createaccount/{customerid}")                     // TO CREATE ACCOUNT FOR AN ACCOUNT HOLDER
	public Account addAccountHolder(@PathVariable("customerid") int customerid,@RequestBody Account account) {
		return accountService.createAccount(customerid,account);
	}
	
}
