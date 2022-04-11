package com.bonshabitos.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Survey {

	public static final String PATH = "C:\\java\\projeto1testes";

	private String title;
	private Person author;
	private List<Person> participants = new ArrayList<>();

	public Survey() {
	}

	public Survey(String title, Person author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public List<Person> getParticipants() {
		return participants;
	}

	public List<Person> sortPeopleByParameter(Comparator<Person> comparator) {
		Collections.sort(participants, comparator);

		return participants;
	}

	public void generateSurveyFile() throws IOException {
		String endPath = PATH + title.trim().toLowerCase() + ".txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(endPath, true));
		bw.write(title.toUpperCase());
		bw.newLine();
		bw.write("Author: " + author.getName());

		for (Person participant : participants) {
			bw.write(participant.extractFirstName() + "," + participant.getCpf() + "," + participant.getAge() + ","
					+ participant.getGender());
			bw.newLine();
		}
		
		bw.close();

	}

}
