package com.agency;

import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Communication {
	public static void showMessage(String messageName) {
	    String message = messageData.get(messageName);
		JOptionPane.showMessageDialog(null, message);
	}

	public static void askQuestion(String questionName) {
		Question question = questionData.get(questionName);
		int result = JOptionPane.showConfirmDialog(null, question.message, "Choose an answer", JOptionPane.YES_NO_OPTION);
	}
	
	static Map<String, String> messageData = Parser.parseMessages("assets/messages.yml");
	static Map<String, Question> questionData = Parser.parseQuestions("assets/questions.yml");
}
