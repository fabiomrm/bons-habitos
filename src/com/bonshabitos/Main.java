package com.bonshabitos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.bonshabitos.entities.Person;
import com.bonshabitos.entities.PersonByAgeComparator;
import com.bonshabitos.entities.PersonByScoreComparator;
import com.bonshabitos.entities.Survey;
import com.bonshabitos.entities.goodhabits.CircularEconomyHabit;
import com.bonshabitos.entities.goodhabits.ConsciousConsumptionHabit;
import com.bonshabitos.entities.goodhabits.FoodHabit;
import com.bonshabitos.entities.goodhabits.GoodHabit;
import com.bonshabitos.enums.Gender;
import com.bonshabitos.interfaces.Validator;
import com.bonshabitos.services.CpfValidator;
import com.bonshabitos.services.EmailValidator;
import com.bonshabitos.utils.Formatter;
import com.bonshabitos.utils.GoodHabitFactory;
import com.bonshabitos.utils.Screen;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Validator cpfValidator = new CpfValidator();
		Validator emailValidator = new EmailValidator();
		// Aqui voc�s v�o colocar Validator emailValidator = new emailValidator();

		Survey survey = new Survey("Atitudes das Pessoas");

		Screen.printPresentation();

		int response = 0;
		while (response != 1 && response != 2) {
			try {
				System.out.println("Digite sua resposta: ");
				response = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Tipo de valor incorreto. S� pode ser 1 ou 2!");
				sc.nextLine();
			}
		}
		if (response == 2) {
			System.out.println("Que pena...At� a pr�xima!");
			System.exit(0);
		}
		sc.nextLine();

		Person p1 = getUserData(sc, cpfValidator, emailValidator);
		survey.getParticipants().add(p1);

		init(sc, p1);
		int res = askToRepeat(sc);
		if (res == 1) {
			do {
				sc.nextLine();
				Person p = getUserData(sc, cpfValidator);
				survey.getParticipants().add(p);
				init(sc, p);
			} while (askToRepeat(sc) == 1);
		}

		handleMenuRequests(sc, survey);

		sc.close();

	}

	public static void handleMenuRequests(Scanner sc, Survey survey) {
		Screen.printSurveyResultMenu();
		int option = 0;
		do {
			List<Person> participants;
			System.out.println("O que voc� deseja?");
			option = sc.nextInt();
			switch (option) {
			case 1:
				participants = survey.getParticipants();
				Screen.printSurveyResult("padr�o", participants);
				break;
			case 2:
				participants = survey.sortPeopleByParameter(new PersonByAgeComparator());
				Screen.printSurveyResult("ordenado por idade", participants);
				break;
			case 3:
				participants = survey.sortPeopleByParameter(new PersonByScoreComparator());
				Screen.printSurveyResult("ordenado por pontua��o", participants);
				break;
			default:
				System.out.println("Valor inv�lido");
			}
		} while (option > 0);
	}

	public static int askToRepeat(Scanner sc) throws InputMismatchException {
		System.out.println("Muito obrigado por ter participado! Mais algu�m deseja participar?");
		System.out.println("1- Sim");
		System.out.println("2- N�o");
		return sc.nextInt();
	}

	public static Person getUserData(Scanner sc, Validator... validators) {

		System.out.print("Digite seu nome: ");
		String name = sc.nextLine();

		name = Formatter.formatName(name);

		System.out.println("Muito prazer, " + name + "! Quantos anos voc� tem: ");
		int age = sc.nextInt();

		sc.nextLine();

		System.out.println("Entre com o seu CPF: ");
		String cpf = sc.nextLine();

		while (!validators[0].validate(cpf)) {
			System.out.println("CPF inv�lido! Digite novamente: ");
			cpf = sc.nextLine();
		}

		// Aqui vem a l�gica da valida��o de email (ver a de cima - cpf)
		System.out.println("Entre com o seu email: ");
		String email = sc.nextLine();

		// AQUI VEM A L�GICA DE N�O ACEITAR NADA QUE N�O SEJA DE 1 A 6
		System.out.println("Qual o seu g�nero? ");
		System.out.println("1- HOMEM-CIS");
		System.out.println("2- HOMEM-TRANS");
		System.out.println("3- MULHER-CIS");
		System.out.println("4- MULHER-TRANS");
		System.out.println("5- N�O-BIN�RIOS");
		System.out.println("6- OUTROS");
		int gender = sc.nextInt();

		return new Person(name, age, email, cpf, Gender.valueOf(gender));
	}

	public static void init(Scanner sc, Person p1) {
		Screen.splitSign("-", 40);
		System.out.printf("%20s%n", "DADOS INICIAIS");
		System.out.print(p1);

		Screen.splitSign("-", 40);

		Screen.printExplanation();

		List<GoodHabit> goodHabits = new ArrayList<>();

		goodHabits.add(GoodHabitFactory.createGoodHabitAlimentacao());
		goodHabits.add(GoodHabitFactory.createGoodHabitEconomiaCircular());
		goodHabits.add(GoodHabitFactory.createGoodHabitConsumoConsciente());

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
				GoodHabit gh = goodHabits.get(2);
				String attitude = gh.getAttitudes().get(choice - 7);
				List<String> suggestions = gh.getSuggestions();

				if (!p1.hasGoodHabit(gh)) {
					GoodHabit userGoodHabit = new ConsciousConsumptionHabit();
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

			p1.setScore(p1.getScore() + 1);

			System.out.println("Tem mais algum? [-1 PARA ENCERRAR]: ");
			choice = sc.nextInt();
		}
		Screen.splitSign("-", 40);
		Screen.printUserGoodHabitsStatus(p1);
	}

}
