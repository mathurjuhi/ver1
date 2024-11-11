package com.bank.banking.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.dto.UserDto;
import com.bank.banking.exception.NotFoundException;
import com.bank.banking.exception.UserNotFoundException;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.UserAccount;
import com.bank.banking.repository.AccountRepository;
import com.bank.banking.repository.UserRepository;
import com.bank.banking.utils.Utils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<AccountDetail> getAllAccounts() {
		List<AccountDetail> userAccs = accountRepo.findAll();
		return userAccs;
	}
	
	@Override
	public AccountDetail getAccountByAccountNum(String accNum) {
		Optional<AccountDetail> account = Optional.ofNullable(accountRepo.findByAccNum(accNum));
		if (account.isPresent()) {
			return account.get();
		} else {
			throw new NotFoundException("Account with account number : " + accNum + " Not Found");
		}
	}
	@Override
	public AccountDetail getAccountById(long id) {
		Optional<AccountDetail> account = accountRepo.findById(id);
		if (account.isPresent()) {
			return account.get();
		} else {
			throw new UserNotFoundException("Account with Id : " + id + " Not Found");
		}
	}

	@Override
	public AccountDetail createAccount(AccountDto accountDto) {
		
		UserAccount user=userRepository.findByUserId(accountDto.getUserId());
		if(user==null)
			throw new UserNotFoundException("User Id : " + accountDto.getUserId() + " Not Found");
		
		AccountDetail account = new AccountDetail();
		account.setAccNum(Utils.generateAccountNumber(10));
		account.setAccType(accountDto.getAccountType());
		account.setActive(true);
		account.setBalance(0);
		account.setCreatedDate(new Date());
		account.setUserAccount(user);
		AccountDetail accountdetail =accountRepo.save(account);
		return accountdetail;
		
	}

	@Override
	public void update(Long accountId, String fn, String ln, String pass, String add, String email, String mob) {
		// TODO Auto-generated method stub
		
	}


/*	@Override
	public void update(Long accountId, String fn, String ln, String pass, String add, String email, String mob) {
		AccountDetail account = getAccountById(accountId);
	/*	if (Objects.nonNull(account.getAccountId())) {
			accountRepo.update(fn, ln, pass, add, email, mob, accountId);
		}
		else {
			throw new UserNotFoundException("User not found to update");
		} } */
	

	/*@Override
	public AccountDetail getAccountById(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public void updateBalance(AccountDetail accountDetail, double amount) {
		// TODO Auto-generated method stub
		
	}*/
}
