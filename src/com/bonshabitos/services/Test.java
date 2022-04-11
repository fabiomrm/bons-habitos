package com.bonshabitos.services;

public class Test {

	public static void main(String[] args) {

		String name = "Fábio Marcone Rodrigues Monteiro";
		
		name.substring(0, name.indexOf(" "));
		System.out.println(name.subSequence(0, name.indexOf(" ")));

	}

}
