package com.bonshabitos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bonshabitos.entities.Person;
import com.bonshabitos.entities.goodhabits.CircularEconomyHabit;
import com.bonshabitos.entities.goodhabits.FoodHabit;
import com.bonshabitos.entities.goodhabits.GoodHabit;
import com.bonshabitos.utils.Formatter;
import com.bonshabitos.utils.GoodHabitFactory;
import com.bonshabitos.utils.Screen;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Exibe a apresenta��o
		Screen.printPresentation();

		int response = sc.nextInt();
		while (response != 1 && response != 2) {
			System.out.println("Digita s� 1 pra continuar ou 2 pra parar...");
			response = sc.nextInt();
		}
		if (response == 2) {
			System.out.println("Que pena...At� a pr�xima!");
			// Encerra o programa com o c�digo 0, que nesse caso indica que encerrou sem
			// problema
			System.exit(0);
		}

		// USU�RIO TOPOU PARTICIPAR
		sc.nextLine();
		System.out.println("BOA! Ent�o l� vamos n�s...");
		System.out.print("\nMas antes de come�ar, digite seu nome: ");
		String name = sc.nextLine();

		// Formata o nome que usu�rio digitou pra deixar ele apresent�vel
		name = Formatter.formatName(name);

		System.out.println("Muito prazer, " + name + "! Quantos anos voc� tem: ");
		int age = sc.nextInt();

		sc.nextLine();

		// Falta criar validador para o CPF
		System.out.println("Entre com o seu CPF: ");
		String cpf = sc.nextLine();

		// Falta criar validador para EMAIL
		System.out.println("Entre com o seu email: ");
		String email = sc.nextLine();

		// Cria um OBJETO da CLASSE Person com os dados informados pelo usu�rio
		Person p1 = new Person(name, age, email, cpf);
		Screen.splitSign("-", 40);

		System.out.println("Esses s�o seus dados iniciais: ");
		System.out.println(p1);

		Screen.splitSign("-", 40);

		// Exibe uma explica��o sobre o programa
		Screen.printExplanation();

		// Cria uma lista VAZIA que vai esperar OBJETOS da CLASSE GoodHabit
		List<GoodHabit> goodHabits = new ArrayList<>();

		// Adiciona os objetos GoodHabits nessa lista que a gente criou (olhar CLASSE
		// GoodHabitFactory)
		goodHabits.add(GoodHabitFactory.createGoodHabitAlimentacao());
		goodHabits.add(GoodHabitFactory.createGoodHabitEconomiaCircular());
		goodHabits.add(GoodHabitFactory.createGoodHabitConsumoConsciente());

		// Agora a gente vai imprimir TODAS as ATITUDES que est�o armazenadas nesta
		// lista de GoodHabits
		Screen.printGoodHabitsAttitudesList(goodHabits);

		System.out.println("E a�, tu pratica alguma dessas coisas? [Aperta -1 para ENCERRAR]: ");
		int choice = sc.nextInt();

		while (choice != -1) {
			if (choice > 0 && choice <= 3) {
				GoodHabit gh = goodHabits.get(0);
				String attitude = gh.getAttitudes().get(choice - 1);
				List<String> suggestions = gh.getSuggestions();

				if (!p1.hasGoodHabit(gh)) {
					GoodHabit userGoodHabit = new FoodHabit();
					userGoodHabit.getAttitudes().add(attitude);

					for (String suggestion : suggestions) {
						userGoodHabit.getSuggestions().add(suggestion);
					}

					p1.getGoodHabits().add(userGoodHabit);
				} else {
					GoodHabit userGoodHabit = p1.findGoodHabit(gh, gh.getTheme());
					userGoodHabit.getAttitudes().add(attitude);

				}
			}

			else if (choice > 3 && choice <= 6) {
				GoodHabit gh = goodHabits.get(1);
				String attitude = gh.getAttitudes().get(choice - 4);
				List<String> suggestions = gh.getSuggestions();

				if (!p1.hasGoodHabit(gh)) {
					GoodHabit userGoodHabit = new CircularEconomyHabit();
					userGoodHabit.getAttitudes().add(attitude);

					for (String suggestion : suggestions) {
						userGoodHabit.getSuggestions().add(suggestion);
					}

					p1.getGoodHabits().add(userGoodHabit);
				} else {
					GoodHabit userGoodHabit = p1.findGoodHabit(gh, gh.getTheme());
					userGoodHabit.getAttitudes().add(attitude);

				}
			}

			else if (choice > 6 && choice <= 9) {
				GoodHabit gh = goodHabits.get(1);
				String attitude = gh.getAttitudes().get(choice - 7);
				List<String> suggestions = gh.getSuggestions();

				if (!p1.hasGoodHabit(gh)) {
					GoodHabit userGoodHabit = new CircularEconomyHabit();
					userGoodHabit.getAttitudes().add(attitude);

					for (String suggestion : suggestions) {
						userGoodHabit.getSuggestions().add(suggestion);
					}

					p1.getGoodHabits().add(userGoodHabit);
				} else {
					GoodHabit userGoodHabit = p1.findGoodHabit(gh, gh.getTheme());
					userGoodHabit.getAttitudes().add(attitude);

				}
			}

			System.out.println("Tem mais algum? [-1 PARA ENCERRAR]: ");
			choice = sc.nextInt();
		}

		Screen.splitSign("-", 40);
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Aguarde...");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("AGORA A GENTE IMPRIME O STATUS DE BONS H�BITOS");
		System.out.println(p1);
		for (GoodHabit gh : p1.getGoodHabits()) {
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

		sc.close();

	}

}
