package com.agency;

import java.util.Map;

public class Question {
	String type;
	String message;
	String name;
	Map<String, String> options;
	
	public Question(String name, String type, String message) {
		this.name = name;
		this.type = type;
		this.message = message;
	}
}