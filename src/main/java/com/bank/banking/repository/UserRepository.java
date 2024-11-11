package com.bank.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.banking.model.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long>{
	UserAccount findByUserId(long userId);

}
