package com.agency;

public class Fact {
	private String name;
	private boolean booleanValue;
	private String stringValue;
	private int intValue;
	
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
	
	Fact(String name, int intValue) {
		this(name);
		this.intValue = intValue;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getBooleanValue() {
		return booleanValue;
	}
	
	public String getStringValue() {
		return stringValue;
	}
	
	public int getIntValue() {
		return intValue;
	}
}
