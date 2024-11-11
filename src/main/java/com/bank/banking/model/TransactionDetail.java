package com.bank.banking.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Transaction_Detail", schema = "online_schema")
public class TransactionDetail {

	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private AccountDetail accountDetail;

	@Column(name = "date_of_transaction")
	private Date transactionDate;

	@Column(name = "transaction_type")
	private String transactionType;

	@NotNull
	private Double amount;

	/*
	 * private Double credit;
	 * 
	 * private Double debit;
	 */

	private Double balance;

	public TransactionDetail() {
	}

	public TransactionDetail(Long transactionId, AccountDetail accountDetail, Date transactionDate,
			String transactionType, @NotNull Double amount, Double balance) {
		super();
		this.transactionId = transactionId;
		this.accountDetail = accountDetail;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public AccountDetail getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/*
	 * public Double getCredit() { return credit; }
	 * 
	 * public void setCredit(Double credit) { this.credit = credit; }
	 * 
	 * public Double getDebit() { return debit; }
	 * 
	 * public void setDebit(Double debit) { this.debit = debit; }
	 * 
	 */
}
