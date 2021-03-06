package controller;

import aux.CustomException;
import aux.InvalidFormatException;
import aux.InvalidPasswordException;
import aux.NonMatchingEntriesException;
import view.DialogView;

public interface DataEditor {
	
	public abstract void editData(String newData) throws CustomException;
	
	public abstract void update();
	
	default void runDoubleInputEditionProtocol(String input1, String input2, String regex, String password) throws CustomException {
		if (input1.equals(input2)) {
			runSimpleInputEditionProtocol(input1, regex, password);
		} else {
			throw new NonMatchingEntriesException();
		}
	}
	
	default void runSimpleInputEditionProtocol(String input, String regex, String password) throws CustomException {
		if (input.matches(regex)) {
			String inputPassword = DialogView.askPassword();
			if (inputPassword != null) {
				if (inputPassword.equals(password)) {
					editData(input);
					update();
				} else {
					throw new InvalidPasswordException();
				}
			}	
		} else {
			throw new InvalidFormatException();
		}
	}
}
