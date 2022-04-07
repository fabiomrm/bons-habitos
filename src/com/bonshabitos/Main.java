package com.bonshabitos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bonshabitos.entities.GoodHabit;
import com.bonshabitos.entities.Person;
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
		Person p1 = new Person();
		p1.setName(name);
		p1.setAge(age);
		p1.setEmail(email);
		p1.setCpf(cpf);
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

		// Agora a gente vai imprimir TODAS as ATITUDES que est�o armazenadas nesta lista de GoodHabits
		Screen.printGoodHabitsAttitudesList(goodHabits);

		System.out.println("E a�, tu pratica alguma dessas coisas? [Aperta -1 para ENCERRAR]: ");
		int choice = sc.nextInt();

		System.out.println("Voc� apertou : " + choice);

		// No final de tudo a gente fecha o nosso scanner (boa pr�tica)
		sc.close();

	}

}
