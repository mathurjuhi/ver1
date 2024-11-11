DROP TABLE IF EXISTS online_schema.Transaction_Detail;
DROP TABLE IF EXISTS online_schema.Account_Detail;
DROP TABLE IF EXISTS online_schema.User_Account;


DROP SCHEMA IF EXISTS online_schema;
CREATE SCHEMA online_schema;

CREATE TABLE online_schema.User_Account(
	user_id BIGINT NOT NULL PRIMARY KEY,
 	first_name VARCHAR(255), 
 	last_name VARCHAR(255), 
 	user_name VARCHAR(20) NOT NULL UNIQUE, 
  	pass VARCHAR(10) NOT NULL,
  	addres VARCHAR(255),
  	dob VARCHAR(30), 
  	email VARCHAR(255), 
  	mobile VARCHAR(10)
  	);

CREATE TABLE online_schema.Account_Detail(
	account_id BIGINT NOT NULL PRIMARY KEY,
 	user_id VARCHAR(20) NOT NULL REFERENCES User_Account(user_id),
 	acc_num VARCHAR(12) NOT NULL,
  	acc_type VARCHAR(10) NOT NULL,
  	is_active BOOLEAN, 
  	created_date VARCHAR(25), 
 	balance NUMERIC(10,3) NOT NULL);
 	
CREATE TABLE online_schema.Transaction_Detail(
	 transaction_id BIGINT NOT NULL PRIMARY KEY,
	 account_id BIGINT NOT NULL REFERENCES Account_Detail(account_id),
	 transaction_type VARCHAR(50) NOT NULL, 
	 amount NUMERIC(10,3) NOT NULL, 
	 balance NUMERIC(10,3) NOT NULL,
	 credit BIGINT,
	 debit BIGINT,
	 date_of_transaction DATE NOT NULL
	 );