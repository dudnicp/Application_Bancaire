package controller;

import aux.CustomException;
import model.User;
import model.WithdrawableAccount;
import view.DataChangeView;

public class MinBalanceChangeController extends DataChangeController {
	
	private WithdrawableAccount account;

	public MinBalanceChangeController(User user, DataChangeView view, Controller controller, WithdrawableAccount account) {
		super(user, view, controller);
		this.account = account;
	}

	@Override
	void changeData(String newData) throws CustomException {
		try {
			double minBalance = Double.parseDouble(newData);
			if (minBalance < account.getBalance()) {
				account.setMinBalance(minBalance);;
			} else {
				throw new CustomException("Le nouveau seuil minimal ne peut pas etre superieur au solde actuel.");
			}
		} catch (NumberFormatException e) {
			throw new CustomException("L'entrée n'est pas un nombre.");
		}
	}
}
