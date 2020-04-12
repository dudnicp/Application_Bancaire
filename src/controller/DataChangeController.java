package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aux.CustomException;
import model.User;
import view.DataChangeView;

public abstract class DataChangeController extends Controller {
	
	protected User user;
	protected DataChangeView view;
	protected Controller parentController;
	
	public DataChangeController(User user, DataChangeView view, Controller controller) {
		this.user = user;
		this.view = view;
		this.parentController = controller;
	}
	
	@Override
	public void setupViewText() {
		// view initialised by previous controller
	}
	
	@Override
	public void displayView() {
		view.setVisible(true);
	}
	
	abstract void changeData(String newData) throws CustomException;
	
	class ConfirmButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getPasswordFieldText().equals(user.getPassword())) {
				if (view.getNewDataFieldText().equals(view.getConfirmDataFieldText())) {
					try {
						changeData(view.getNewDataFieldText());
						view.displaySucessfulModificationMessage();
						parentController.setupViewText();
						view.dispose();
					} catch (CustomException e2) {
						view.displayCustomError(e2.getString());
					}
				}
				else {
					view.displayNonMatchingFieldsError();
				}
			} else {
				view.displayInvalidPasswordError();
			}
		}
	}
	
	@Override
	public void setupViewButtons() {
		view.addAnnulButtonListener(new AnnulButtonListener());
		view.addConfirmButtonListener(new ConfirmButtonListener());
	}
	
	class AnnulButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose();
		}
	}

}
