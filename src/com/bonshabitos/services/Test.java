package com.bonshabitos.services;

import com.bonshabitos.interfaces.Validator;

public class Test {

	public static void main(String[] args) {

		String email = "marcos@gmail.com";

		Validator emailValidator = new EmailValidator();

		System.out.println(emailValidator.validate(email));

	}

}
