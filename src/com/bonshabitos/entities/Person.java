package com.bonshabitos.entities;

public class Person extends User {

	private int age;
	private String cpf;
	private String email;
	private Address address;

	public Person() {
	}

	public Person(String name, int age, String email, String cpf) {
		super.setName(name);
		this.age = age;
		this.email = email;
		this.cpf = cpf;

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String s = "Nome: " + super.getName();
		s += "\nIdade: " + age;
		s += "\nCPF: " + cpf;
		s += "\nEmail: " + email;

		return s;
	}

}
