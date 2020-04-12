package controller;

import aux.CustomException;
import model.User;
import view.DataChangeView;

public class PhoneNumberChangeController extends DataChangeController {

	public PhoneNumberChangeController(User user, DataChangeView view, PreferencesController controller) {
		super(user, view, controller);
	}
	
	@Override
	public void setupView() {
		super.setupView();
	}

	@Override
	void changeData(String newData) throws CustomException {
		if (newData.matches("0[0-9]{9}")) {
			user.setPhoneNumber(newData);
		}
		else {
			throw new CustomException("Format téléphone invalide.");
		}
	}

}
