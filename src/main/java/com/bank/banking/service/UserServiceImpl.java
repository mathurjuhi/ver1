package com.bank.banking.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banking.dto.UserDto;
import com.bank.banking.exception.UserNotFoundException;
import com.bank.banking.model.UserAccount;
import com.bank.banking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserAccount createUser(UserDto user) {

		UserAccount userAccount = new UserAccount();
		userAccount.setFirstName(user.getFirstName());
		userAccount.setLastName(user.getLastName());
		userAccount.setUserName(user.getUserName());
		userAccount.setPassword(user.getPass());
		userAccount.setAddress(user.getAddres());
		userAccount.setEmail(user.getEmail());
		userAccount.setMobile(user.getMobile());
		userAccount.setDob(user.getDob());
		//userAccount.setAccounts(new ArrayList<AccountDetail>());

		UserAccount account2 = userRepository.save(userAccount);
		if (account2 != null)
			return account2;
		else
			throw new ConstraintViolationException("User with user id:" + user.getUserName() + "already exist.",
					null, user.getUserName());

	}
	
	@Override
	public List<UserAccount> getAllUsers() {
		List<UserAccount> userAccs = userRepository.findAll();
		return userAccs;
	}

	@Override
	public UserAccount getUserById(long userId) {
		Optional<UserAccount> user = Optional.ofNullable(userRepository.findByUserId(userId));
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserNotFoundException("User with userId "+ userId +" doesnot exist");
	}

}
