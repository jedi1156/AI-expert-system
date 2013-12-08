package com.agency;

public class Fact {
	private String name;
	private boolean booleanValue;
	private String stringValue;
	
	Fact(String name) {
		this.name = name;
	}
	
	Fact(String name, boolean booleanValue) {
		this(name);
		this.booleanValue = booleanValue;
	}
	
	Fact(String name, String stringValue) {
		this(name);
		this.stringValue = stringValue;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getBooleanValue() {
		return booleanValue;
	}
}
