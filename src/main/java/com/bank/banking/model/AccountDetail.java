package com.bank.banking.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Account_Detail"
, schema="online_schema")
public class AccountDetail {
	
	public AccountDetail() {}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private long accountId;

	@Column(name = "acc_num")
    private String accNum;
	
    @Column (name ="balance")
    @NotNull
    private double balance;
    
    @Column(name = "acc_type")
    private String accType;
	
    @Column(name = "is_active")
    private boolean isActive;
    
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserAccount userAccount;
    
    @OneToMany(mappedBy="accountDetail")
    private List<TransactionDetail> transactionDetail;
    
	public AccountDetail(long accountId, String accNum, @NotNull double balance, String accType,
			boolean isActive, Date createdDate) {
		super();
		this.accountId = accountId;
		this.accNum = accNum;
		this.balance = balance;
		this.accType = accType;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "AccountDetail [accountId=" + accountId +  ", accNum=" + accNum + ", balance="
				+ balance + ", accType=" + accType + ", isActive=" + isActive + ", createdDate=" + createdDate + "]";
	}

}
