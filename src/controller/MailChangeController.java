package controller;

import aux.CustomException;
import model.User;
import view.DataChangeView;

public class MailChangeController extends DataChangeController {

	public MailChangeController(User user, DataChangeView view, PreferencesController controller) {
		super(user, view, controller);
	}

	@Override
	void changeData(String newData) throws CustomException {
		if (newData.matches(".+"+"@"+".+"+"."+".+")) {
			user.setEmail(newData);
		} else {
			throw new CustomException("Format mail invalide.");
		}
	}
}
