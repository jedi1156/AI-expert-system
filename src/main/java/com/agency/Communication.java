package com.agency;

import java.util.Map;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
		KnowledgeSession.addFact(new Fact(question.name, result == JOptionPane.YES_OPTION));
	}
	
	static void askNumericQuestion(Question question) {
		String data = JOptionPane.showInputDialog(null, question.message);
		try {
			int result = Integer.parseInt(data);
			KnowledgeSession.addFact(new Fact(question.name, result));
		} catch (java.lang.NumberFormatException t) {
			askNumericQuestion(question);
		}
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
		try {
			int data = list.getSelectedIndices()[0];
			Choice result = question.choices.get(data);
			KnowledgeSession.addFact(new Fact(question.name, result.name));
		}
		catch (java.lang.ArrayIndexOutOfBoundsException t) {
			askMultipleQuestion(question);
		}
	}
	
	static Map<String, String> messageData = Parser.parseMessages("assets/messages.yml");
	static Map<String, Question> questionData = Parser.parseQuestions("assets/questions.yml");
}
