package com.bonshabitos.entities;

import java.util.ArrayList;
import java.util.List;

public class Survey {

	private String title;
	private List<Person> participants = new ArrayList<>();

	public Survey() {
	}

	public Survey(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Person> getParticipants() {
		return participants;
	}

}
