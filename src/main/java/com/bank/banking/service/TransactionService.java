package com.bank.banking.service;

import org.hibernate.Transaction;

import com.bank.banking.dto.TransferDto;
import com.bank.banking.model.TransactionDetail;

public interface TransactionService {

	TransactionDetail deposit(Long id, double amount);

	TransactionDetail withdraw(Long id, double amount);

	String transferAmount(TransferDto transferDto);
	
	/*    void recordTransaction(Long accountId, double amount, String type); */
}
