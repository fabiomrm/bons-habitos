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
import com.bonshabitos.utils.Formatter;
import com.bonshabitos.utils.GoodHabitFactory;
import com.bonshabitos.utils.Screen;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Validator cpfValidator = new CpfValidator();
		// Aqui vocês vão colocar Validator emailValidator = new emailValidator();

		Survey survey = new Survey("Atitudes das Pessoas");

		Screen.printPresentation();

		int response = 0;
		while (response != 1 && response != 2) {
			try {
				System.out.println("Digite sua resposta: ");
				response = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Tipo de valor incorreto. Só pode ser 1 ou 2!");
				sc.nextLine();
			}
		}
		if (response == 2) {
			System.out.println("Que pena...Até a próxima!");
			System.exit(0);
		}
		sc.nextLine();

		// AQUI VOCÊS VÃO MUDAR o método getUserData pra receber também um
		// emailValidator getUserData(sc, cpfValidator, emailValidator)
		Person p1 = getUserData(sc, cpfValidator);
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

		// FALTA IMPLEMENTAR AS OPÇÕES DO MENU. PODE SER AQUI MESMO. COMO FAZER
		// 1. Pega lista de participantes da pesquisa (survey.getParticipants())
		// 2. faz um loop FOR por ela e para cada participante coloca para imprimir
		// (system.out...) [OPÇÃO 1]
		// 3. faz um loop FOR por ela e para cada participante verifica se
		// participante.getAge() é maior que a do outro [OPÇÃO 2]
		// 4. mesma do 3 mas com participante.getScore()
		// Dica para 3 e 4 => existe uma interface chamada Comparable com um método
		// compare (implementar na entidade Person)
		

		sc.close();

	}

	public static void handleMenuRequests(Scanner sc, Survey survey) {
		Screen.printSurveyResultMenu();
		int option = 0;
		do {
			List<Person> participants;
			System.out.println("O que você deseja?");
			option = sc.nextInt();
			switch (option) {
			case 1:
				participants = survey.getParticipants();
				System.out.println(participants);
				break;
			case 2:
				participants = survey.sortPeopleByParameter(new PersonByAgeComparator());
				System.out.println(participants);
				break;
			case 3:
				participants = survey.sortPeopleByParameter(new PersonByScoreComparator());
				System.out.println(participants);
			}
		} while (option > 0);
	}

	public static int askToRepeat(Scanner sc) throws InputMismatchException {
		System.out.println("Muito obrigado por ter participado! Mais alguém deseja participar?");
		System.out.println("1- Sim");
		System.out.println("2- Não");
		return sc.nextInt();
	}

	// Com o validator email, esse método vai virar: getUserData(Scanner sc,
	// Validator validator, Validator validator2)
	public static Person getUserData(Scanner sc, Validator validator) {
		System.out.print("Digite seu nome: ");
		String name = sc.nextLine();

		name = Formatter.formatName(name);

		System.out.println("Muito prazer, " + name + "! Quantos anos você tem: ");
		int age = sc.nextInt();

		sc.nextLine();

		System.out.println("Entre com o seu CPF: ");
		String cpf = sc.nextLine();

		while (!validator.validate(cpf)) {
			System.out.println("CPF inválido! Digite novamente: ");
			cpf = sc.nextLine();
		}

		// Aqui vem a lógica da validação de email (ver a de cima - cpf)
		System.out.println("Entre com o seu email: ");
		String email = sc.nextLine();

		// AQUI VEM A LÓGICA DE NÃO ACEITAR NADA QUE NÃO SEJA DE 1 A 6
		System.out.println("Qual o seu gênero? ");
		System.out.println("1- HOMEM-CIS");
		System.out.println("2- HOMEM-TRANS");
		System.out.println("3- MULHER-CIS");
		System.out.println("4- MULHER-TRANS");
		System.out.println("5- NÃO-BINÁRIOS");
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

		System.out.println("E aí, tu pratica alguma dessas coisas? [Aperta -1 para ENCERRAR]: ");
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
