package controller;

import aux.CustomException;
import model.PersonalAccount;
import model.User;
import view.DataChangeView;

public class BalanceCeilingChangeController extends DataChangeController {
	
	private PersonalAccount account;

	public BalanceCeilingChangeController(User user, DataChangeView view, Controller controller, PersonalAccount account) {
		super(user, view, controller);
		this.account = account;
	}

	@Override
	void changeData(String newData) throws CustomException {
		try {
			double newCeiling = Double.parseDouble(newData);
			if (newCeiling > account.getBalance()) {
				account.setBalanceCeiling(newCeiling);
			} else {
				throw new CustomException("Le nouveau plafond ne peut pas etre inférieur au solde actuel.");
			}
		} catch (NumberFormatException e) {
			throw new CustomException("L'entrée n'est pas un nombre.");
		}
	}
}
