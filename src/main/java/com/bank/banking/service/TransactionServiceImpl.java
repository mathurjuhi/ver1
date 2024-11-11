package com.bank.banking.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.banking.dto.TransferDto;
import com.bank.banking.exception.InsufficientFundException;
import com.bank.banking.exception.UserNotFoundException;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.TransactionDetail;
import com.bank.banking.repository.AccountRepository;
import com.bank.banking.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public TransactionDetail deposit(Long id, double amount) {
		AccountDetail account = accountRepository.findByAccountId(id);

		if (account == null)
			throw new UserNotFoundException("Account with Id : " + id + " Not Found");
		Double balance = account.getBalance() + amount;
		//update balance in account
		account.setBalance(balance);
		accountRepository.save(account);

		//add new row in transaction
		TransactionDetail transaction = new TransactionDetail();
		transaction.setAccountDetail(account);
		transaction.setAmount(amount);
		transaction.setBalance(balance);
		transaction.setTransactionType("Deposit");
		transaction.setTransactionDate(new Date());
		transactionRepository.save(transaction);

		return transaction;
	}

	@Override
	public TransactionDetail withdraw(Long id, double amount) {
		AccountDetail account = accountRepository.findByAccountId(id);

		if (account == null)
			throw new UserNotFoundException("Account with Id : " + id + " Not Found");
		
		if (account.getBalance() < amount)  
			throw new InsufficientFundException("User has not sufficient balance to withdraw"); 
		
		Double balance = account.getBalance() - amount;
		//update balance in account
		account.setBalance(balance);
		accountRepository.save(account);

		//add new row in transaction
		TransactionDetail transaction = new TransactionDetail();
		transaction.setAccountDetail(account);
		transaction.setAmount(amount);
		transaction.setBalance(balance);
		transaction.setTransactionType("Withdraw");
		transaction.setTransactionDate(new Date());
		transactionRepository.save(transaction);

		return transaction;
	}

	@Override
	@Transactional
	public String transferAmount(TransferDto transferDto) {

		AccountDetail srcAccount = accountRepository.findByAccountId(transferDto.getSourceAccount());
		AccountDetail destAccount = accountRepository.findByAccountId(transferDto.getDestinationAccount());
		
		double srcAmount = 0;
		double destAmount = 0;
		
		if(srcAccount == null) {
				throw new UserNotFoundException("Account with Id : " + transferDto.getSourceAccount() + " Not Found");
		}
		if(destAccount == null) {
			throw new UserNotFoundException("Account with Id : " + transferDto.getDestinationAccount() + " Not Found");
		}
		if(srcAccount.getBalance() < transferDto.getAmount()) {
			throw new InsufficientFundException("Insuffiecient balance in the source account");
		}
		
		srcAmount = srcAccount.getBalance() - transferDto.getAmount();
		srcAccount.setBalance(srcAmount);
		accountRepository.save(srcAccount);
		
		destAmount = destAccount.getBalance() + transferDto.getAmount();
		destAccount.setBalance(destAmount);
		accountRepository.save(destAccount);
		
		//saveTransaction(sourceAccountId, destinationAccountId, amount, "DEBIT");
		//saveTransaction(sourceAccountId, destinationAccountId, amount, "CREDIT");
		
		TransactionDetail transferDebit = new TransactionDetail();
		
			transferDebit.setAccountDetail(srcAccount);
			transferDebit.setAmount(transferDto.getAmount());
			transferDebit.setBalance(srcAmount);
			transferDebit.setTransactionType("Transfer: Debit");
			transferDebit.setTransactionDate(new Date());
			transactionRepository.save(transferDebit);
			
			TransactionDetail transferCredit = new TransactionDetail();
			transferCredit.setAccountDetail(destAccount);
			transferCredit.setAmount(transferDto.getAmount());
			transferCredit.setBalance(destAmount);
			transferCredit.setTransactionType("Transfer: Credit");
			transferCredit.setTransactionDate(new Date());
			transactionRepository.save(transferCredit);
		
		
		return "Amount transferred successfully";
	}

	/*@Autowired
    private TransactionRepository transactionRepository;
 	public void recordTransaction(Long accountId, double amount, String type) {
	        // Create a new Transaction object
	        Transaction transaction = new Transaction();
	        transaction.setAccountId(accountId);
	        transaction.setAmount(amount);
	        transaction.setType(type);
	        transaction.setDate(new Date());

	        // Save the transaction using the repository
	        transactionRepository.save(transaction);
	    }
	    */
}
