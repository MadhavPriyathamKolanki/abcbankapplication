package com.bankingapp.abcbankapplication.model;

public class FundTransfer {
	private int fromaccountnumber;
	private int toaccountnumber;
	private int transactionamount;

	public int getFromaccountnumber() {
		return fromaccountnumber;
	}

	public void setFromaccountnumber(int fromaccountnumber) {
		this.fromaccountnumber = fromaccountnumber;
	}

	public int getToaccountnumber() {
		return toaccountnumber;
	}

	public void setToaccountnumber(int toaccountnumber) {
		this.toaccountnumber = toaccountnumber;
	}

	public int getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(int transactionamount) {
		this.transactionamount = transactionamount;
	}

	public FundTransfer() {

	}

	public FundTransfer(int fromaccountnumber, int toaccountnumber, int transactionamount) {
		super();
		this.fromaccountnumber = fromaccountnumber;
		this.toaccountnumber = toaccountnumber;
		this.transactionamount = transactionamount;
	}

}
