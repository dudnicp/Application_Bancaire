package controller;

import aux.CustomException;
import view.DialogView;

public interface DataEditor {
	
	public abstract void editData(String newData);
	
	public abstract void update();
	
	default void runDoubleInputEditionProtocol(String input1, String input2, String regex, String password) throws CustomException {
		if (input1.equals(input2)) {
			runSimpleInputEditionProtocol(input1, regex, password);
		} else {
			throw new CustomException("Les deux entrées ne corréspondent pas");
		}
	}
	
	default void runSimpleInputEditionProtocol(String input, String regex, String password) throws CustomException {
		if (input.matches(regex)) {
			String inputPassword = DialogView.askPassword();
			if (inputPassword != null) {
				if (inputPassword.equals(password)) {
					editData(input);
					DialogView.displayInfoDialog("Modification enregistrée avec succès", "Confirmation");
					update();
				} else {
					throw new CustomException("Code secret invalide");
				}
			}	
		} else {
			throw new CustomException("Format invalide");
		}
	}
}
