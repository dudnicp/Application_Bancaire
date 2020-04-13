package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aux.CustomException;
import model.User;
import view.DialogView;
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
			String[] input = DialogView.getDoubleStringOption(
					"Entrez nouveau mail: ", "Confirmez nouveau mail: ", "Édition mail", false, false);
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) {
							loggedUser.setEmail(newData);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runDoubleInputEditionProtocol(
							input[0], input[1], ".+"+"@"+".+"+"."+".+", loggedUser.getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
	
	
	class PhoneNumberChangeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringOption(
					"Entrez nouveau téléphone: ", "Confirmez nouveau téléphone: ", "Édition téléphone", false, false);
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) {
							loggedUser.setPhoneNumber(newData);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runDoubleInputEditionProtocol(
							input[0], input[1], "0[0-9]{9}", loggedUser.getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
	
	
	class AdressChangeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringOption(
					"Entrez nouvelle adresse: ", "Confirmez adresse: ", "Édition adresse", false, false);
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) {
							loggedUser.setAdress(newData);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runDoubleInputEditionProtocol(
							input[0], input[1], ".*", loggedUser.getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
	
	class PasswordChangeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringOption(
					"Entrez nouveau code secret: ", "Confirmez code secret: ", "Édition code secret", true, true);
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) {
							loggedUser.setPassword(newData);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runDoubleInputEditionProtocol(
							input[0], input[1], ".*", loggedUser.getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}

	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(0, new MailChangeButton());
		view.addButtonAction(1, new PhoneNumberChangeButton());
		view.addButtonAction(2, new AdressChangeButton());
		view.addButtonAction(3, new PasswordChangeButton());		
	}
}
