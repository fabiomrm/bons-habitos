package com.bonshabitos.entities;

import java.util.ArrayList;
import java.util.List;

public class GoodHabit {

	private String theme;
	private List<String> attitudes = new ArrayList<>();
	private List<String> suggestions = new ArrayList<>();

	public GoodHabit() {
	}

	public GoodHabit(String theme, List<String> attitudes, List<String> suggestions) {
		super();
		this.theme = theme;
		this.attitudes = attitudes;
		this.suggestions = suggestions;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<String> getAttitudes() {
		return attitudes;
	}

	public void setAttitudes(List<String> attitudes) {
		this.attitudes = attitudes;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}

}
