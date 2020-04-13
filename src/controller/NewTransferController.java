package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import aux.CustomException;
import model.Account;
import model.User;
import view.DialogView;
import view.NewTransferView;

public class NewTransferController extends Controller {
	
	private User user;
	private NewTransferView view;
	
	
	public NewTransferController(User user, NewTransferView view) {
		this.user = user;
		this.view = view;
	}
	
	@Override
	public void displayView() {
		view.setVisible(true);
	}
	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(new NewPayeeButton());
	}
	@Override
	public void setupViewText() {
		view.setMainLabelText(0, "Depuis le compte: ");
		view.setMainLabelText(1, "Vers le compte: ");
		view.setMainLabelText(2, "Montant: ");
		view.setCheckBoxText("Virement pérmanent?");
		
		ArrayList<Object> withdrawableAccounts = new ArrayList<Object>();
		withdrawableAccounts.addAll(user.getWithdrawableAccounts());
		
		ArrayList<Object> payees = new ArrayList<Object>();
		payees.addAll(user.getPayees());
		
		for (Object account : withdrawableAccounts) {
			view.addOptionToList1(account);
		}
		
		for (Object payee : payees) {
			view.addOptionToList2(payee);
		}
		
		view.setButtonText("Ajouter bénéficiaire");
	}
	
	class NewPayeeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringInput("IBAN: ", "Nom du bénéficiare: ", "Nouveau bénéficiare", false, false);
			if (input != null) {
				String iban = input[0];
				String name = input[1];
				
				class Editor implements DataEditor {
					@Override
					public void editData(String newData) throws CustomException {
						Account payee = new Account(iban, name);
						user.addPayee(payee);
						view.addOptionToList2(payee);
					}
					@Override
					public void update() {
						// nothing to be done
					}
				}
				
				Editor editor = new Editor();
				try {
					editor.runSimpleInputEditionProtocol(iban, "[A-Z0-9]{10}", user.getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
			
		}
	}
	
}
