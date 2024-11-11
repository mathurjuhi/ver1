package com.bank.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.UserAccount;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetail, Long> {
	
	AccountDetail findByAccNum(String accNum);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE USER_ACCOUNT SET FIRST_NAME=?1, LAST_NAME=?2,PASS=?3,ADDRES=?4, EMAIL=?5, MOBILE=?6 WHERE ACCOUNT_ID=?7", nativeQuery = true)
	void update(String fn, String ln, String pass, String add, String email, String mob, Long accountId);
	
	AccountDetail findByAccountId(long accountId);

	
}
