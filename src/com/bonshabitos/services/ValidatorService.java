package com.bonshabitos.services;

import com.bonshabitos.interfaces.Validator;

public class ValidatorService implements Validator {

	@Override
	public boolean validate(String identifer) {
		//Verifica se o n�mero tem 11 d�gitos
		
		//Valida��o do primeiro d�gito
		//1 - Multiplica os 9 primeiros d�gitos pela sequ�ncia decrescente de 10 at� 2
		//2 - Soma o resultado, multiplca por 10, divide por 11 e armazena o resto
		
		//3 - SE PRIMEIRO
		return false;
	}

	@Override
	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
