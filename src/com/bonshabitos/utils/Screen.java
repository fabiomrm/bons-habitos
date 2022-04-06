package com.bonshabitos.utils;

public class Screen {

	public static void printPresentation() {
		System.out.println("BONS HÁBITOS");
		System.out.println("Olá! Seja bem vinde ao projeto BONS HÁBITOS!");
		System.out
				.println("Nosso objetivo é mostrar como seus atos diários impactam positivamente para o meu ambiente");
		System.out.println(
				"Ah! E de quebra, a gente vai te dar algumas sugestões pra continuar nessa pegada sustentável");
		System.out.println();
		System.out.println("E ai? Bora tirar teu EXTRATO DE BONS HÁBITOS? ");
	}
	
	public static void splitSign(String str, int amount) {
		System.out.println();
		for(int i=0; i < amount; i++) {
			System.out.print(str);
		}
		System.out.println();
	}
}
