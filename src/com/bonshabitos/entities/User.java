package com.bonshabitos.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bonshabitos.enums.Theme;

public abstract class User {

	private String name;
	private String email;
	private List<GoodHabit> goodHabits = new ArrayList<>();

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<GoodHabit> getGoodHabits() {
		return goodHabits;
	}

	public boolean hasGoodHabit(GoodHabit goodHabit) {
		for (int i = 0; i < getGoodHabits().size(); i++) {
			if (goodHabit.getTheme().equals(getGoodHabits().get(i).getTheme())) {
				return true;
			}
		}
		return false;
	}

	public GoodHabit findGoodHabit(GoodHabit gh, Theme theme) {
		return gh = getGoodHabits().stream().filter(x -> x.getTheme().equals(theme)).collect(Collectors.toList())
				.get(0);
	}

}
