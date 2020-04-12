package controller;

import aux.CustomException;
import model.User;
import view.DataChangeView;

public class PasswordChangeController extends DataChangeController{

	public PasswordChangeController(User user, DataChangeView view, PreferencesController controller) {
		super(user, view, controller);
	}

	@Override
	void changeData(String newData) throws CustomException {
		user.setPassword(newData);
	}

}
