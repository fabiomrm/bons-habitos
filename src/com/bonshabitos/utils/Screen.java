package com.bonshabitos.utils;

public class Screen {

	public static void printPresentation() {
		System.out.println("BONS H�BITOS");
		System.out.println("Ol�! Seja bem vinde ao projeto BONS H�BITOS!");
		System.out
				.println("Nosso objetivo � mostrar como seus atos di�rios impactam positivamente para o meu ambiente");
		System.out.println(
				"Ah! E de quebra, a gente vai te dar algumas sugest�es pra continuar nessa pegada sustent�vel");
		System.out.println();
		System.out.println("E ai? Bora tirar teu EXTRATO DE BONS H�BITOS? ");
	}
	
	public static void splitSign(String str, int amount) {
		System.out.println();
		for(int i=0; i < amount; i++) {
			System.out.print(str);
		}
		System.out.println();
	}
}
