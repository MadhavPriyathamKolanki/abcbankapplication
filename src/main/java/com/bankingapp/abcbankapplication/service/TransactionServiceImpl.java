package com.bankingapp.abcbankapplication.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.abcbankapplication.model.Transaction;
import com.bankingapp.abcbankapplication.repository.AccountRepository;
import com.bankingapp.abcbankapplication.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public List<Transaction> getLastTenTransactions(int accountid) {
		return transactionRepository.findTxnsByAccountId(accountid);
	}
	
	@Override
	public List<Transaction> getDetailedTransactionsByDate(int accountid, String fromdate, String todate) {
		return transactionRepository.findDetailedTransactionsByDate(accountid, fromdate, todate);
	}

	@Override
	public List<Transaction> getDetailedTransactionsByAmount(int accountid, int minamnt, int maxamnt) {
		return transactionRepository.findDetailedTransactionsByAmount(accountid, minamnt, maxamnt);
	}

	@Override
	public List<Transaction> getDetailedTransactionsByFromAccount(int accountid, int fromaccid) {
		System.out.println(accountid + fromaccid);
		return transactionRepository.getDetailedTransactionsByFromAccount(accountid, fromaccid);
	}

	@Override
	public List<Transaction> getDetailedTransactionsByToAccount(int accountid, int toaccid) {
		System.out.println(accountid + toaccid);
		return transactionRepository.getDetailedTransactionsByToAccount(accountid, toaccid);
	}


}
