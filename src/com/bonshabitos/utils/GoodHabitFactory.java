package com.bonshabitos.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bonshabitos.entities.GoodHabit;
import com.bonshabitos.enums.Theme;

public class GoodHabitFactory {

	/*
	 * Cada MÉTODO dessa classe vai criar um OBJETO da CLASSE GoodHabit e depois vai
	 * retornar esse OBJETO
	 */

	public static GoodHabit createGoodHabitAlimentacao() {
		List<String> attitudes = new ArrayList<>();
		attitudes.add("Sou vegetariano");
		attitudes.add("Deixo de comer carne pelo menos uma vez na semana");
		attitudes.add("Compro alimentos orgânicos");

		List<String> suggestions = new ArrayList<>();
		suggestions.add("Guia Alimentar de Dietas Vegetarianas para Adultos");
		suggestions.add("Cowspiracy");
		suggestions.add("Troque agrotóxicos por uma dose de felicidade");

		GoodHabit goodHabit = new GoodHabit(Theme.ALIMENTACAO, attitudes, suggestions);

		return goodHabit;
	}

	public static GoodHabit createGoodHabitEconomiaCircular() {

		List<String> atittudes = Arrays.asList("Compro em brechós", "Reciclo e reuso",
				"Descarto de maneira adequada após uso");
		List<String> suggestions = Arrays.asList("Dá uma olhada em empresas que são adeptas: Natura, L'oréal, Unilever",
				"Segue esses perfis de uns brechós massa: @dprafrente_brecho, @dbs_brecho, @brechodakombi",
				"Site Enjoei");

		GoodHabit goodHabit = new GoodHabit(Theme.ECONOMIA_CIRCULAR, atittudes, suggestions);

		return goodHabit;
	}

	public static GoodHabit createGoodHabitConsumoConsciente() {

		List<String> atittudes = Arrays.asList("Compro apenas os alimentos que vou consumir/não desperdiço comida;",
				"Uso ecobags", "Uso eletrodomésticos com alta eficiência energética (Selo A - Procel)");
		List<String> suggestions = Arrays.asList("O Custo Verdadeiro", "Obsolescência Programada");

		GoodHabit goodHabit = new GoodHabit(Theme.CONSUMO_CONSCIENTE, atittudes, suggestions);

		return goodHabit;
	}

}
