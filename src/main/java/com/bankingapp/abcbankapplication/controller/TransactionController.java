package com.bankingapp.abcbankapplication.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.abcbankapplication.model.Customer;
import com.bankingapp.abcbankapplication.model.Transaction;
import com.bankingapp.abcbankapplication.repository.AccountRepository;
import com.bankingapp.abcbankapplication.repository.TransactionRepository;
import com.bankingapp.abcbankapplication.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionService transactionService;
	@GetMapping(value = "/getminitxns/{accountid}")  
	public List<Transaction> getLastTenTransactions(@PathVariable("accountid") int accountid) {
		return transactionService.getLastTenTransactions(accountid);
	}
	
	@GetMapping(value = "/getdetailedtxnsbydate/{accountid}/{fromdate}/{todate}")  
	public List<Transaction> getDetailedTransactionsByDate(@PathVariable("accountid") int accountid,
			@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate) {
		return transactionService.getDetailedTransactionsByDate(accountid,fromdate,todate);
	}
	
	@GetMapping(value = "/getdetailedtxnsbyamnt/{accountid}/{minamnt}/{maxamnt}")  
	public List<Transaction> getDetailedTransactionsByAmount(@PathVariable("accountid") int accountid,
			@PathVariable("minamnt") int minamnt, @PathVariable("maxamnt") int maxamnt) {
		return transactionService.getDetailedTransactionsByAmount(accountid,minamnt,maxamnt);
	}
	@GetMapping(value = "/getdetailedtxnsbyfrmactno/{accountid}/{fromaccid}")  
	public List<Transaction> getDetailedTransactionsByFromAccount(@PathVariable("accountid") int accountid,
			@PathVariable("fromaccid") int fromaccid) {
		System.out.println(accountid + fromaccid);
		return transactionService.getDetailedTransactionsByFromAccount(accountid,fromaccid);
	}
	@GetMapping(value = "/getdetailedtxnsbytoactno/{accountid}/{toaccid}")  
	public List<Transaction> getDetailedTransactionsByToAccount(@PathVariable("accountid") int accountid,
			@PathVariable("toaccid") int toaccid) {
		System.out.println(accountid + toaccid);
		return transactionService.getDetailedTransactionsByToAccount(accountid,toaccid);
	}
}
