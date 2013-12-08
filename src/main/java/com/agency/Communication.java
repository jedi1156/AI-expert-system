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
		if (question.type.equals("boolean")) {
			askBooleanQuestion(question);
		}
		else if (question.type.equals("numeric")) {
			askNumericQuestion(question);
		}
	}
	
	static void askBooleanQuestion(Question question) {
		int result = JOptionPane.showConfirmDialog(null, question.message, "Choose an answer", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			// TODO: handle YES
		}
		else {
			// TODO handle NO
		}
	}
	
	static void askNumericQuestion(Question question) {
		String data = JOptionPane.showInputDialog(null, question.message);
		int result = Integer.parseInt(data);
		// TODO handle result
	}
	
	static Map<String, String> messageData = Parser.parseMessages("assets/messages.yml");
	static Map<String, Question> questionData = Parser.parseQuestions("assets/questions.yml");
}
