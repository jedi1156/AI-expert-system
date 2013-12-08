package com.agency;

import java.util.Map;

import javax.swing.JOptionPane;

public class Communication {
	public static void showMessage(String messageName) {
	    Map<String, String> data = Parser.parseMessages("assets/messages.yml");
	    String message = data.get(messageName);
		JOptionPane.showMessageDialog(null, message);
	}

	public static void askQuestion(String questionName) {
		
	}
}
