package com.bonshabitos.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Survey {

	private String title;
	private Person author;
	private List<Person> participants = new ArrayList<>();

	public Survey() {
	}

	public Survey(String title, Person author) {
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

	public List<Person> sortPeopleByParameter(Comparator<Person> comparator) {
		Collections.sort(participants, comparator);

		return participants;
	}

}
