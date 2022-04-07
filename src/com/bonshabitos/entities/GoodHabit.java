package com.bonshabitos.entities;

import java.util.ArrayList;
import java.util.List;

import com.bonshabitos.enums.Theme;

public class GoodHabit {

	private Theme theme;
	private List<String> attitudes = new ArrayList<>();
	private List<String> suggestions = new ArrayList<>();

	public GoodHabit() {
	}

	public GoodHabit(Theme theme, List<String> attitudes, List<String> suggestions) {
		super();
		this.theme = theme;
		this.attitudes = attitudes;
		this.suggestions = suggestions;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<String> getAttitudes() {
		return attitudes;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}

}
