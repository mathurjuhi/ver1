package com.bank.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bank.banking.model.TransactionDetail;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetail, Long> {
	@Query(value = "SELECT * FROM Transaction acc WHERE account_id = ?1", nativeQuery = true)
	TransactionDetail getTransactionDetailById(Long accountId);
}
