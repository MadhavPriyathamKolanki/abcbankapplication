package com.bankingapp.abcbankapplication.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankingapp.abcbankapplication.ExceptionHandling.CustomerNotFoundException;
import com.bankingapp.abcbankapplication.ExceptionHandling.InsufficientFundsException;
import com.bankingapp.abcbankapplication.ExceptionHandling.InvalidAccountNumberException;
import com.bankingapp.abcbankapplication.model.Account;
import com.bankingapp.abcbankapplication.model.Customer;
import com.bankingapp.abcbankapplication.model.FundTransfer;
import com.bankingapp.abcbankapplication.model.Transaction;
import com.bankingapp.abcbankapplication.repository.AccountRepository;
import com.bankingapp.abcbankapplication.repository.CustomerRepository;
import com.bankingapp.abcbankapplication.repository.TransactionRepository;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Account createAccount(int customerid, Account account) {
		Optional<Customer> holder = customerRepository.findById(customerid);
		if(!holder.isPresent()) {
			throw new CustomerNotFoundException("The customer with this id is not found");
		}
		account.setCustomer(holder.get());
		accountRepository.save(account);
		return account;
		
	}

	@Override
	public List<Account> getAccountsByCustomerId(int customerId) {
		return accountRepository.findAccountsByCustomerId(customerId);
	}

	@Override
	public Account getAccountByAccountId(int accountid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction transferamount(FundTransfer fundtransfer) throws
	InsufficientFundsException,InvalidAccountNumberException {
		System.out.println(fundtransfer.getFromaccountnumber());
		System.out.println(fundtransfer.getToaccountnumber());
		System.out.println(fundtransfer.getTransactionamount());
		Account from_account = accountRepository.findAccountByAccountId(fundtransfer.getFromaccountnumber())
				.orElseThrow(() -> new InvalidAccountNumberException("The from account number entered is invalid" ));
		 int balance = from_account.getBalance();
		 if(balance<fundtransfer.getTransactionamount()) {
			 throw new InsufficientFundsException("insufficent funds to do withdrawl");
		 }
		 from_account.setBalance(balance - fundtransfer.getTransactionamount());
			accountRepository.save(from_account);
			
			Transaction transaction1 = new Transaction(fundtransfer.getTransactionamount(),fundtransfer.getFromaccountnumber(),
					fundtransfer.getToaccountnumber(),"DEBIT",balance,new Date(),new Date(),"successful","TXN_SUCCESS",from_account);
			transactionRepository.save(transaction1);
			Account to_account = accountRepository.findAccountByAccountId(fundtransfer.getToaccountnumber())
					.orElseThrow(() -> new InvalidAccountNumberException("The account number entered is invalid" ));
			int to_account_balance = to_account.getBalance();
			to_account.setBalance(to_account_balance + fundtransfer.getTransactionamount());
			accountRepository.save(to_account);
			Transaction transaction2 = new Transaction(fundtransfer.getTransactionamount(),fundtransfer.getFromaccountnumber(),
					fundtransfer.getToaccountnumber(),"CREDIT",to_account_balance,new Date(),new Date(),"successful","TXN_SUCCESS",to_account);
			transactionRepository.save(transaction2);
		return transaction1;
		
	}

	
	
	
	
	
}
