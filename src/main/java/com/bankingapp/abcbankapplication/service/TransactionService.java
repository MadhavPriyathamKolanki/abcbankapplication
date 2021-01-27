package com.bankingapp.abcbankapplication.service;


import java.util.List;

import com.bankingapp.abcbankapplication.model.Transaction;



public interface TransactionService {
	public List<Transaction> getLastTenTransactions(int accountid);
	
	public List<Transaction> getDetailedTransactionsByDate(int accountid,String fromdate,String todate);
	public List<Transaction> getDetailedTransactionsByAmount(int accountid,int minamnt,int maxamnt);
	public List<Transaction> getDetailedTransactionsByFromAccount(int accountid,int fromaccid);
	public List<Transaction> getDetailedTransactionsByToAccount(int accountid,int toaccid);
}
