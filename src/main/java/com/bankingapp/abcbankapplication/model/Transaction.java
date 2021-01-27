package com.bankingapp.abcbankapplication.model;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	@Column
	private int transactionamount;
	@Column
	private int fromaccountnumber;
	@Column
	private int toaccountnumber;
	@Column
	private String transactiontype;
	@Column
	private int balanceondate;
	@Temporal(value = TemporalType.DATE)
	@Column
	private Date transactiondate;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column
	private Date transactiontimestamp;
	@Column
	private String transactionremarks;
	@Column
	private String transactionstatus;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Account account;

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(int transactionamount) {
		this.transactionamount = transactionamount;
	}

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

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public int getBalanceondate() {
		return balanceondate;
	}

	public void setBalanceondate(int balanceondate) {
		this.balanceondate = balanceondate;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public Date getTransactiontimestamp() {
		return transactiontimestamp;
	}

	public void setTransactiontimestamp(Date transactiontimestamp) {
		this.transactiontimestamp = transactiontimestamp;
	}

	public String getTransactionremarks() {
		return transactionremarks;
	}

	public void setTransactionremarks(String transactionremarks) {
		this.transactionremarks = transactionremarks;
	}

	public String getTransactionstatus() {
		return transactionstatus;
	}

	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transaction() {

	}

	public Transaction(int transactionamount, int fromaccountnumber, int toaccountnumber, String transactiontype,
			int balanceondate, Date transactiondate, Date transactiontimestamp, String transactionremarks,
			String transactionstatus, Account account) {
		super();
		this.transactionamount = transactionamount;
		this.fromaccountnumber = fromaccountnumber;
		this.toaccountnumber = toaccountnumber;
		this.transactiontype = transactiontype;
		this.balanceondate = balanceondate;
		this.transactiondate = transactiondate;
		this.transactiontimestamp = transactiontimestamp;
		this.transactionremarks = transactionremarks;
		this.transactionstatus = transactionstatus;
		this.account = account;
	}

	public Transaction(int transactionid, int transactionamount, int fromaccountnumber, int toaccountnumber,
			String transactiontype, int balanceondate, Date transactiondate, Date transactiontimestamp,
			String transactionremarks, String transactionstatus, Account account) {
		super();
		this.transactionid = transactionid;
		this.transactionamount = transactionamount;
		this.fromaccountnumber = fromaccountnumber;
		this.toaccountnumber = toaccountnumber;
		this.transactiontype = transactiontype;
		this.balanceondate = balanceondate;
		this.transactiondate = transactiondate;
		this.transactiontimestamp = transactiontimestamp;
		this.transactionremarks = transactionremarks;
		this.transactionstatus = transactionstatus;
		this.account = account;
	}
}
