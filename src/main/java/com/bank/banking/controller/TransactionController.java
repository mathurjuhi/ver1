package com.bank.banking.controller;

import com.bank.banking.dto.AccountDto;
import com.bank.banking.dto.TransferDto;
import com.bank.banking.model.AccountDetail;
import com.bank.banking.model.TransactionDetail;
import com.bank.banking.repository.TransactionRepository;
import com.bank.banking.service.AccountService;
import com.bank.banking.service.TransactionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banking")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    private TransactionRepository transRepo;

    // API to get all transactions for a specific account
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDetail>> getTransactionById(@PathVariable Long accountId) {
        List<TransactionDetail> transactions = (List<TransactionDetail>) transRepo.getTransactionDetailById(accountId);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no transactions found
        }
        else {
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }}
    
    @PostMapping("/transaction/deposit/{accountId}")
    public  ResponseEntity<TransactionDetail> deposit(@PathVariable Long accountId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        TransactionDetail transaction= transactionService.deposit(accountId, amount);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    @PostMapping("/transaction/withdraw/{accountId}")
    public ResponseEntity<TransactionDetail> withdraw(@PathVariable Long accountId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        TransactionDetail transaction=  transactionService.withdraw(accountId, amount);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }
    
    @PostMapping("/transfer")
    public ResponseEntity<String> transferAmount(@Valid @RequestBody TransferDto transferDto){
    	 String transaction =  transactionService.transferAmount(transferDto);
    	return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
    
   /* @Autowired
    private AccountService accountService;

    @PutMapping("/update")
    public ResponseEntity<String> updateTransaction(@RequestParam Long accountId, 
                                                    @RequestParam double amount, 
                                                    @RequestParam String type) {
        try {
            if (!type.equalsIgnoreCase("deposit") && !type.equalsIgnoreCase("withdraw")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid transaction type. Use 'deposit' or 'withdraw'.");
            }

            AccountDetail accountDetail = accountService.getAccountById(accountId);
            if (accountDetail == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Account not found.");
            }

            if (type.equalsIgnoreCase("deposit")) {
                accountService.updateBalance(accountDetail, amount);
                transactionService.recordTransaction(accountId, amount, "DEPOSIT");
                return ResponseEntity.ok("Deposit successful.");
            } else if (type.equalsIgnoreCase("withdraw")) {
                if (accountDetail.getBalance() < amount) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Insufficient balance.");
                }
                accountService.updateBalance(accountDetail, -amount);
                transactionService.recordTransaction(accountId, amount, "WITHDRAW");
                return ResponseEntity.ok("Withdrawal successful.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing transaction: " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request.");
    } */
}
