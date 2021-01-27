package com.bankingapp.abcbankapplication.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountid;
	@Column
	private int balance;
	@Column
	private String branch;
	@Column
	private String accounttype;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customerid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Customer customer;

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account() {

	}

	public Account(int balance, String branch, String accounttype) {
		super();
		this.balance = balance;
		this.branch = branch;
		this.accounttype = accounttype;
	}

	public Account(int balance, String branch, String accounttype, Customer customer) {
		super();
		this.balance = balance;
		this.branch = branch;
		this.accounttype = accounttype;
		this.customer = customer;
	}

	public Account(int accountid, int balance, String branch, String accounttype, Customer customer) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.branch = branch;
		this.accounttype = accounttype;
		this.customer = customer;
	}

}
