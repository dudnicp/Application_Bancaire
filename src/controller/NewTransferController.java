package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import aux.CustomException;
import model.Account;
import model.TransferRegularity;
import model.User;
import model.WithdrawableAccount;
import view.DialogView;
import view.NewTransferView;

public class NewTransferController extends Controller {
	
	private User user;
	private NewTransferView view;
	private WithdrawableAccount payer;
	
	
	public NewTransferController(User user, NewTransferView view, WithdrawableAccount payer) {
		this.user = user;
		this.view = view;
		this.payer = payer;
	}
	
	@Override
	public void displayView() {
		view.setVisible(true);
	}
	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(new NewPayeeButton());
		view.addCheckBoxListener(new CheckBoxListener());
	}
	@Override
	public void setupViewText() {
		view.setMainLabelText(0, "Vers le compte: ");
		
		ArrayList<Object> payees = new ArrayList<Object>();
		payees.addAll(user.getPayees());
		payees.remove(payer);
		for (Object account : payees) {
			view.addOption(account);
		}
		
		view.setMainLabelText(1, "Montant: ");
		
		view.setButtonText("Ajouter bénéficiaire");
		
		view.setCheckBoxText("Virement permanent?");
		
		view.setAuxLabelText(0, "Régularité: ");
		
		for (TransferRegularity regularity : TransferRegularity.values()) {
			view.addAuxOption(regularity);
		}
		
		view.setAuxLabelText(1, "Date du premier transfert: ");
	}
	
	
	
	class CheckBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.isCheckBoxChecked()) {
				view.showAuxContent();
			} else {
				view.hideAuxContent();
				for (int i = 0; i < 3; i++) {
					view.setAuxField(i, "");
				}
				view.setAuxOption(TransferRegularity.MONTHLY);
			}
		}
	}
	
	class NewPayeeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringInput(
					"IBAN: ", "Nom du bénéficiare: ", "Nouveau bénéficiare", false, false);
			if (input != null) {
				String iban = input[0];
				String name = input[1];
				
				class Editor implements DataEditor {
					@Override
					public void editData(String newData) throws CustomException {
						Account payee = new Account(iban, name);
						user.addPayee(payee);
						view.addOption(payee);
						DialogView.displayInfoDialog("Nouveau bénéficiare enregistré avec succès.", null);
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
