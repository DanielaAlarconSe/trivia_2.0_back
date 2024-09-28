package com.ciber.util;

import org.springframework.security.authentication.BadCredentialsException;

public class DisabledException extends BadCredentialsException{

	   public DisabledException(String msg) {
		   
	       super(msg);
	       
	   }
	   
	private static final long serialVersionUID = 1L;

}
