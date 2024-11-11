package com.bank.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking.dto.UserDto;
import com.bank.banking.model.UserAccount;
import com.bank.banking.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/banking")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	@RequestMapping("/add/user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userdto){

		UserAccount account = userService.createUser(userdto);
		return new ResponseEntity<>(account,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserAccount>> getAllUsers() {
		List<UserAccount> userAccs = userService.getAllUsers();
		return ResponseEntity.ok(userAccs);
	}
	
	
	@GetMapping("/getUser/{userId}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long userId) {
		UserAccount user = userService.getUserById(userId);
		if (user != null) {
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Return 404 if not found
	    }
	}

}
