package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import view.DataChangeView;
import view.PreferencesView;

public class PreferencesController extends Controller {
	
	private User loggedUser;
	private PreferencesView view;
	
	public PreferencesController(User user, PreferencesView view) {
		this.loggedUser = user;
		this.view = view;
	}

	@Override
	public void setupViewText() {
		view.setLabelText(0, "Mail:");
		view.setLabelText(1, loggedUser.getEmail());
		view.setLabelText(2, "Téléphone:");
		view.setLabelText(3, loggedUser.getPhoneNumber());
		view.setLabelText(4, "Adresse:");
		view.setLabelText(5, loggedUser.getAdress());
		
		view.setButtonText(0, "Changer");
		view.setButtonText(1, "Changer");
		view.setButtonText(2, "Changer");
		view.setButtonText(3, "Changer code secret");
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	class MailChangeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DataChangeView newView = new DataChangeView(null, "Modification mail", false, "mail", false);
			MailChangeController controller = new MailChangeController(loggedUser, newView, PreferencesController.this);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class PhoneNumberChangeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DataChangeView newView = new DataChangeView(null, "Modification téléphone", true, "téléphone", false);
			PhoneNumberChangeController controller = new PhoneNumberChangeController(loggedUser, 
					newView, PreferencesController.this);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class AdressChangeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DataChangeView newView = new DataChangeView(null, "Modification adresse", true, "adresse", true);
			AdressChangeController controller = new AdressChangeController(loggedUser, newView, PreferencesController.this);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class PasswordChangeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DataChangeView newView = new DataChangeView(null, "Modification code secret", true, "code secret", false);
			PasswordChangeController controller = new PasswordChangeController(loggedUser, newView, PreferencesController.this);
			controller.setupView();
			controller.displayView();
		}
	}

	@Override
	public void setupViewButtons() {
		view.addButtonAction(0, new MailChangeButton());
		view.addButtonAction(1, new PhoneNumberChangeButton());
		view.addButtonAction(2, new AdressChangeButton());
		view.addButtonAction(3, new PasswordChangeButton());		
	}
}
