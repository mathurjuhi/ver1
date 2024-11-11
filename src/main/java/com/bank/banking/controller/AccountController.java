
package com.bank.banking.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking.dto.UserDto;
import com.bank.banking.exception.NotFoundException;
import com.bank.banking.dto.AccountDto;
import com.bank.banking.dto.AccountUpdateDto;
import com.bank.banking.model.UserAccount;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/banking")
public class AccountController {
	
	@Autowired

	private AccountService accountService;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<AccountDetail>> getAllAccounts() {
		List<AccountDetail> userAccs = accountService.getAllAccounts();
		return ResponseEntity.ok(userAccs);
	}
	
	@GetMapping("/getAccount/{accountNum}")
    public ResponseEntity<AccountDetail> getAccountByAccountNum(@PathVariable String accountNum) {
		AccountDetail account = accountService.getAccountByAccountNum(accountNum);
		if (account != null) {
	        return new ResponseEntity<>(account, HttpStatus.OK);
	    } else {
	        throw new NotFoundException("Account not found " + accountNum); // Return 404 if not found
	    }
	}

	@PostMapping
	@RequestMapping("/add/account")
	public ResponseEntity<AccountDetail> createNewAccount(@Valid @RequestBody AccountDto accountDto){
		
		AccountDetail account = accountService.createAccount(accountDto);
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
    
    @PutMapping("/account/update/{accountId}")
    public ResponseEntity<String> update(@PathVariable Long accountId, @RequestBody AccountUpdateDto updateAccount){
    	accountService.update(accountId,updateAccount.getFirstName(),updateAccount.getLastName(),updateAccount.getPass(),updateAccount.getAddres(),updateAccount.getEmail(), updateAccount.getMobile());
		return new ResponseEntity<>("Update Successful",HttpStatus.OK);
    	
    }
}
