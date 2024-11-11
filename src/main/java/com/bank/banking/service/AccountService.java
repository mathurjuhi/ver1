package com.bank.banking.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.dto.UserDto;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.UserAccount;
import com.bank.banking.repository.AccountRepository;

public interface AccountService {

	public List<AccountDetail> getAllAccounts();
	
	public AccountDetail getAccountByAccountNum(String accountNum);

	public AccountDetail getAccountById(long id);

	public AccountDetail createAccount(AccountDto account) ;

	public void update(Long accountId, String fn, String ln, String pass, String add, String email, String mob);
	
	
	/*public AccountDetail getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public void updateBalance(AccountDetail accountDetail, double amount) {
        accountDetail.setBalance(accountDetail.getBalance() + amount);
        accountRepository.save(accountDetail);
    }*/


}
