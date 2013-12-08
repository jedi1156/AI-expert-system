package com.agency;

import java.util.Map;

import javax.swing.JOptionPane;

public class Communication {
	public static void showMessage(String messageName) {
	    String message = messageData.get(messageName);
		JOptionPane.showMessageDialog(null, message);
	}

	public static void askQuestion(String questionName) {
		
	}
	
	static Map<String, String> messageData = Parser.parseMessages("assets/messages.yml");
}
