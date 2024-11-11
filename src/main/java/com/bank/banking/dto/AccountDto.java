package com.bank.banking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AccountDto {
	
	@NotNull(message = "User Id cannot be NULL")
	long userId;
	
	@NotEmpty(message = "Account Type cannot be blank")
	@NotNull(message = "Account Type cannot be NULL")
	String accountType;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
