package com.intimetec.restaurant.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class SecurePassword {
	public static String encryptPassword(String password) {
		 
		 password+="qazws";		
		 Encoder encoder = Base64.getEncoder();
	
		 String encodedPassword = encoder.encodeToString(password.getBytes());
		
		 return encodedPassword;
	}

	public static String decryptPassword(String password) {
		Decoder decoder = Base64.getDecoder();
		
		password = new String(decoder.decode(password));
		
		String originalPassword="";
		for(int i = 0; i<password.length()-5;i++) {
			originalPassword+=password.charAt(i);
		}
		return originalPassword;
	}
}
