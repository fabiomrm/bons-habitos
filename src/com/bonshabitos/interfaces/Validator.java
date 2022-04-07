package com.bonshabitos.interfaces;

public interface Validator {

	boolean validate(String identifer);
	
	boolean validateEmail(String email);
}
