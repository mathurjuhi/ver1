package com.bank.banking.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "User_Account", schema="online_schema")
public class UserAccount{
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	@NotNull
	private long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_name")
	@NotNull
	private String userName;
	
	@Column(name = "pass")
	private String password;
	
	@Column(name = "addres")
	private String address;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	/*
	 * @OneToMany(mappedBy = "userAccount") private List<AccountDetail> accounts =
	 * new ArrayList<>();
	 */
	public UserAccount() {
		
	}

	public UserAccount(@NotNull long userId, String firstName, String lastName, @NotNull String userName,
			String password, String address, LocalDate dob, String email, String mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/*
	 * public List<AccountDetail> getAccounts() { return accounts; }
	 * 
	 * public void setAccounts(List<AccountDetail> accounts) { this.accounts =
	 * accounts; }
	 */

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", address=" + address + ", dob=" + dob + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	
	

}
