package com.bank.banking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TransferDto {

		@NotNull(message = "Source account cannot be null")
		private long sourceAccount;
		
		@NotNull(message = "Destination account cannot be null")
		private long destinationAccount;
		
		@NotNull(message = "Amount cannot be null")
		private double amount;
		
	
		public long getSourceAccount() {
			return sourceAccount;
		}
		public void setSourceAccount(long sourceAccount) {
			this.sourceAccount = sourceAccount;
		}
		public long getDestinationAccount() {
			return destinationAccount;
		}
		public void setDestinationAccount(long destinationAccount) {
			this.destinationAccount = destinationAccount;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public TransferDto(long sourceAccount, long destinationAccount, double amount) {
			super();
			this.sourceAccount = sourceAccount;
			this.destinationAccount = destinationAccount;
			this.amount = amount;
		}
		
		
		
}
