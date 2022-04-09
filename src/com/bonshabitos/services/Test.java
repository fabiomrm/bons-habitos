package com.bonshabitos.services;

public class Test {
	// Primeiramente multiplica-se os 9 primeiros d�gitos pela sequ�ncia decrescente
	// de n�meros de 10 � 2 e soma os resultados.
	// Assim:
	// 5 * 10 + 2 * 9 + 9 * 8 + 9 * 7 + 8 * 6 + 2 * 5 + 2 * 4 + 4 * 3 + 7 * 2

	public static void main(String[] args) {
		String cpf = "70164328076";
		int resto;
		if (cpf.length() != 11) {
			System.out.println("\nN�mero de cpf inv�lido: ");
		}

		else {
			String vetor[] = cpf.split("");
			int contador = 11;
			int soma = 0;
			for (int i = 0; i < 9; i++) {
				System.out.println(vetor[i] + " * " + (contador - 1));
				soma += Integer.parseInt(vetor[i]) * (contador - 1);
				contador--;
			}
			System.out.println(soma);
			resto = soma * 10 % 11;
			if (resto == 10) {
				resto = 0;
			}
			if (resto == Integer.parseInt(vetor[9])) {
				System.out.println("Valor do primeiro d�gito validado!");
			}

			// Verificando o segundo d�gito
			contador = 12;
			soma = 0;
			for (int i = 0; i < 10; i++) {
				System.out.println(vetor[i] + " * " + (contador - 1));
				soma += Integer.parseInt(vetor[i]) * (contador - 1);
				contador--;
			}
			System.out.println(soma);
			resto = soma * 10 % 11;
			if(resto == 10) {
				resto =0;
			}
			
			if(resto == Integer.parseInt(vetor[10])) {
				System.out.println("Valor do segundo d�gito validado");
			}

		}

	}

}
