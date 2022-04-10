package com.bonshabitos.utils;

import java.util.List;

import com.bonshabitos.entities.Person;
import com.bonshabitos.entities.User;
import com.bonshabitos.entities.goodhabits.GoodHabit;

public class Screen {

	public static void printSurveyResult(String title, List<Person> participants) {
		StringBuffer sb = new StringBuffer();
		sb.append(title.toUpperCase() + "\n");
		int c = 0;
		sb.append(c + " - " + "Nome " + "Idade " + "Pontua��o \n");
		for (Person participant : participants) {
			sb.append("\n" + (c + 1) + "-" + participant.getName() + " " + participant.getAge() + " "
					+ participant.getScore() + "\n");
		}

		System.out.print(sb.toString());
	}

	public static void printSurveyResultMenu() {
		// compare (implementar na entidade Person)
		System.out.println("MENU DE EXIBI��O DOS RESULTADOS");
		String[] opcoes = { "1 - Exibir participantes", "2 - Ordenar por idade", "3 - Ordenar por pontua��o" };
		for (String opcao : opcoes) {
			System.out.println(opcao);
		}
	}

	public static void printUserGoodHabitsStatus(User user) {
		System.out.println(user);
		for (GoodHabit gh : user.getGoodHabits()) {
			Screen.splitSign("-", 30);
			System.out.print("TEMA: ");
			System.out.print(gh.getTheme());
			Screen.splitSign("-", 30);
			System.out.println("ATIITUDES: ");
			for (String attitude : gh.getAttitudes()) {
				System.out.println(attitude);
			}
			System.out.println("SUGEST�ES: ");
			for (String suggestion : gh.getSuggestions()) {
				System.out.println(suggestion);
			}
			System.out.println("===================");
		}

	}

	/*
	 * Nesse m�todo a gente recebe uma LISTA com OBJETOS da CLASSE GoodHabit e
	 * percorre com um LOOP FOR. Como cada OBJETO GoodHabit possui uma LISTA DE
	 * ATITUDES, eu percorro essa lista e IMPRIMO cada valor da LISTA DE ATITUDES.
	 */
	public static void printGoodHabitsAttitudesList(List<GoodHabit> goodHabits) {
		System.out.println("LISTA DE BONS H�BITOS: ");

		int c = 0;
		for (int i = 0; i < goodHabits.size(); i++) {
			for (int j = 0; j < goodHabits.get(i).getAttitudes().size(); j++) {
				System.out.println((c + 1) + "- " + goodHabits.get(i).getAttitudes().get(j));
				c++;
				System.out.println();
			}
		}
	}

	public static void printPresentation() {
		System.out.println("BONS H�BITOS");
		System.out.println("Ol�! Seja bem vinde ao projeto BONS H�BITOS!");
		System.out.println("Nosso objetivo � mostrar como seus atos di�rios impactam positivamente o meu ambiente");
		System.out.println(
				"Ah! E de quebra, a gente vai te dar algumas sugest�es pra continuar nessa pegada sustent�vel");
		System.out.println();
		System.out.println("E ai? Bora tirar teu EXTRATO DE BONS H�BITOS? ");
		System.out.println("1- Simbora!");
		System.out.println("2- T� fora...");
	}

	public static void printExplanation() {
		splitSign("-", 40);
		System.out.println("Vai funcionar assim: ");
		System.out.println("N�s vamos te mostrar uma lista de h�bitos;");
		System.out.println("Dentre as op��es, tu vai escolher quais tu pratica;");
		System.out.println("Pra cada uma delas, a gente vai mostrar um pouco sobre e te dar mais dicas;");
		System.out.println("No final, a gente vai falar emitir teu EXTRATO DE BONS H�BITOS!");
		splitSign("-", 40);
	}

	public static void splitSign(String str, int amount) {
		System.out.println();
		for (int i = 0; i < amount; i++) {
			System.out.print(str);
		}
		System.out.println();
	}
}
