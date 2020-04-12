package controller;

import aux.CustomException;
import model.User;
import model.WithdrawableAccount;
import view.DataChangeView;

public class WithdrawalCeilingChangeController extends DataChangeController {
	
	private WithdrawableAccount account;

	public WithdrawalCeilingChangeController(User user, DataChangeView view, Controller controller, WithdrawableAccount account) {
		super(user, view, controller);
		this.account = account;
	}

	@Override
	void changeData(String newData) throws CustomException {
		try {
			double newCeiling = Double.parseDouble(newData);
			if (newCeiling > account.getCurrentlyEngagedAmount()) {
				account.setWithrdrawalCeiling(newCeiling);
			} else {
				throw new CustomException("Le nouveau plafond ne peut pas etre inferieur au montant engagé");
			}
		} catch (NumberFormatException e) {
			throw new CustomException("L'entrée n'est pas un nombre.");
		}
	}
}
