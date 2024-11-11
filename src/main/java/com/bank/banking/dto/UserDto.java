package com.bank.banking.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDto {
	@Valid

	@NotEmpty(message = "First name cannot be blank")
	@NotNull(message = "First name cannot be NULL")
	private String firstName;

	@NotEmpty(message = "Last name cannot be blank")
	@NotNull(message = "Last name cannot be NULL")
	private String lastName;

	@Email(message = "Please enter a valid email Id")
	@NotNull(message = "Email cannot be NULL")
	@NotEmpty(message = "Email cannot be blank")
	private String email;

	@NotEmpty(message = "User name cannot be blank")
	@NotNull(message = "User name cannot be NULL")
	private String userName;

	@NotEmpty(message = "Password cannot be blank")
	@NotNull(message = "Password cannot be NULL")
	private String pass;

	@NotEmpty(message = "Address cannot be blank")
	@NotNull(message = "Address cannot be NULL")
	private String addres;

	@NotEmpty(message = "Mobile cannot be blank")
	@NotNull(message = "Mobile cannot be NULL")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Please enter 10 digit mobile number")
	private String mobile;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "DOB cannot be NULL")
	private LocalDate dob;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
