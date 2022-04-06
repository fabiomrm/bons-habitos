package com.bonshabitos.utils;

import java.util.ArrayList;
import java.util.List;

import com.bonshabitos.entities.GoodHabit;

public class GoodHabitFactory {

	public static GoodHabit createGoodHabitAlimentacao() {
		List<String> attitudes = new ArrayList<>();
		attitudes.add("Sou vegetariano");
		attitudes.add("Deixo de comer carne pelo menos uma vez na semana");
		attitudes.add("Compro alimentos org�nicos");

		List<String> suggestions = new ArrayList<>();
		suggestions.add("Guia Alimentar de Dietas Vegetarianas para Adultos");
		suggestions.add("Cowspiracy");
		suggestions.add("Troque agrot�xicos por uma dose de felicidade");

		GoodHabit gh = new GoodHabit("ALIMENTA��O", attitudes, suggestions);

		return gh;
	}

}
