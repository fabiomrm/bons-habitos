package com.bonshabitos.services;

public class Test {
	// Primeiramente multiplica-se os 9 primeiros dígitos pela sequência decrescente
	// de números de 10 à 2 e soma os resultados.
	// Assim:
	// 5 * 10 + 2 * 9 + 9 * 8 + 9 * 7 + 8 * 6 + 2 * 5 + 2 * 4 + 4 * 3 + 7 * 2

	public static void main(String[] args) {
		String cpf = "70164328076";
		int resto;
		if (cpf.length() != 11) {
			System.out.println("\nNúmero de cpf inválido: ");
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
				System.out.println("Valor do primeiro dígito validado!");
			}

			// Verificando o segundo dígito
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
				System.out.println("Valor do segundo dígito validado");
			}

		}

	}

}
