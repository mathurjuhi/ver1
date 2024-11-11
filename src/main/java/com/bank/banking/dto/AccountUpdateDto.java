package com.bank.banking.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountUpdateDto {

	public AccountUpdateDto() {}
	
    private String firstName;

    private String lastName;
    
    private String email;
	    
    private String pass;

    private String addres;

    private String mobile;


    public AccountUpdateDto(String firstName, String lastName, String email, String pass, String addres, String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pass = pass;
		this.addres = addres;
		this.mobile = mobile;
	}
	
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

	@Override
	public String toString() {
		return "AccountUpdateDto [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", pass=" + pass + ", addres="
				+ addres + ", mobile=" + mobile + "]";
	}


}
