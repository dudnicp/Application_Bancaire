package controller;

import java.util.ArrayList;

import model.User;
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
		// TODO Auto-generated method stub
		
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
	
	
	
}
