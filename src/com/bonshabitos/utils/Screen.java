package com.bonshabitos.utils;

import java.util.List;

import com.bonshabitos.entities.Person;
import com.bonshabitos.entities.User;
import com.bonshabitos.entities.goodhabits.GoodHabit;

public class Screen {

	public static void printSurveyResult(String title, List<Person> participants) {
		
		splitSign("=", 80);
		System.out.printf(Color.ANSI_CYAN + "%40s" + Color.ANSI_RESET, title.toUpperCase());
		System.out.printf("%n%-20s %20s %35s", "NOME", "IDADE", "PONTUAÇÃO");
		splitSign("=", 80);
		for (Person participant : participants) {
			System.out.printf("%-20s %20s %35s%n", participant.extractFirstName(), participant.getAge(),
					participant.getScore());
		}
		splitSign("=", 80);
	}

	public static void printSurveyResultMenu() {
		System.out.println("MENU DE EXIBIÇÃO DOS RESULTADOS");
		String[] opcoes = { "1 - Exibir participantes", "2 - Ordenar por idade", "3 - Ordenar por pontuação" };
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
			System.out.println("SUGESTÕES: ");
			for (String suggestion : gh.getSuggestions()) {
				System.out.println(suggestion);
			}
			System.out.println("===================");
		}

	}

	public static void printGenderOptions() {
		System.out.println("1- HOMEM-CIS");
		System.out.println("2- HOMEM-TRANS");
		System.out.println("3- MULHER-CIS");
		System.out.println("4- MULHER-TRANS");
		System.out.println("5- NÃO-BINÁRIOS");
		System.out.println("6- OUTROS");
	}

	public static void printGoodHabitsAttitudesList(List<GoodHabit> goodHabits) {
		System.out.println("LISTA DE BONS HÁBITOS: ");

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
		System.out.println("BONS HÁBITOS");
		System.out.println("Olá! Seja bem vinde ao projeto BONS HÁBITOS!");
		System.out.println("Nosso objetivo é mostrar como seus atos diários impactam positivamente o meu ambiente");
		System.out.println(
				"Ah! E de quebra, a gente vai te dar algumas sugestões pra continuar nessa pegada sustentável");
		System.out.println();
		System.out.println("E ai? Bora tirar teu EXTRATO DE BONS HÁBITOS? ");
		System.out.println("1- Simbora!");
		System.out.println("2- Tô fora...");
	}

	public static void printExplanation() {
		splitSign("-", 40);
		System.out.println("Vai funcionar assim: ");
		System.out.println("Nós vamos te mostrar uma lista de hábitos;");
		System.out.println("Dentre as opções, tu vai escolher quais tu pratica;");
		System.out.println("Pra cada uma delas, a gente vai mostrar um pouco sobre e te dar mais dicas;");
		System.out.println("No final, a gente vai falar emitir teu EXTRATO DE BONS HÁBITOS!");
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
