package com.bank.banking.utils;

import java.util.Random;

public class Utils {
	
	private static final Random RANDOM = new Random();
	
	public static String generateAccountNumber(int len) {
		 String accountNumber = "AC";
		for (int i = 0; i < len; ++i) {
			int n = RANDOM.nextInt(10) + 0;
			accountNumber += Integer.toString(n);
        }
		return accountNumber;
		
	}

}
