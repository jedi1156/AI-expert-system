
public class Fact {
	String name;
	boolean booleanValue;
	String stringValue;
	
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
}
