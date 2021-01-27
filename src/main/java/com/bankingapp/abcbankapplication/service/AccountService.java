package com.bankingapp.abcbankapplication.service;

import java.util.List;

import com.bankingapp.abcbankapplication.model.Account;
import com.bankingapp.abcbankapplication.model.FundTransfer;
import com.bankingapp.abcbankapplication.model.Transaction;

public interface AccountService {
	public Account createAccount(int customerid, Account account);
	public List<Account> getAccountsByCustomerId(int customerId);
	public Account getAccountByAccountId(int accountid);
	public Account updateAccount(Account account);
	public Transaction transferamount(FundTransfer fundtransfer);
	
}
