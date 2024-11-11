package com.bank.banking.service;

import java.util.List;

import com.bank.banking.dto.UserDto;
import com.bank.banking.model.UserAccount;

public interface UserService {
	
	public UserAccount createUser(UserDto user);
	
	public List<UserAccount> getAllUsers();
	
	public UserAccount getUserById(long userId);

}
