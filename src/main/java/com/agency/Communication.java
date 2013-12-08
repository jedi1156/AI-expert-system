package com.agency;

import java.util.Map;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

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
		else if (question.type.equals("multiple")) {
			askMultipleQuestion(question);
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
	
	static void askMultipleQuestion(Question question) {
		ArrayList<String> answers = new ArrayList<String>();
		for (Choice choice : question.choices) {
			answers.add(choice.message);
		}
		JList list = new JList(answers.toArray());
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		Object[] options = {question.message, list};
		JOptionPane.showMessageDialog(null, options, "Choose an answer", JOptionPane.PLAIN_MESSAGE);
		int data = list.getSelectedIndices()[0];
		Choice result = question.choices.get(data);
		// TODO handle result
	}
	
	static Map<String, String> messageData = Parser.parseMessages("assets/messages.yml");
	static Map<String, Question> questionData = Parser.parseQuestions("assets/questions.yml");
}
