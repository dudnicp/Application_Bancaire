package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import aux.CustomException;
import model.PermanentTransfer;
import model.User;
import model.WithdrawableAccount;
import view.AllPayeesView;
import view.AllTransfersView;
import view.DialogView;
import view.NewTransferView;
import view.PermanentTransferView;

public class AllTransfersController extends Controller {

	private User user;
	private AllTransfersView view;
	private MainMenuController mainMenuController;
	
	public AllTransfersController(User user, AllTransfersView view, MainMenuController controller) {
		this.user = user;
		this.view = view;
		this.mainMenuController = controller;
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(0, new NewTransferButton());
		view.addButtonAction(1, new PayeeManagmentButton());
	}

	@Override
	public void setupViewText() {
		view.setButtonText(0, "Nouveau virement");
		view.setButtonText(1, "Gestion des bénéficiares");
		
		TitledBorder title1 = new TitledBorder("Liste des virements permanents");
		title1.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.setListBorder(title1);
		
		for (PermanentTransfer transfer : user.getPermanentTransfers()) {
			PermanentTransferView transferView = new PermanentTransferView();
			PermanentTransferController controller = new PermanentTransferController(transfer, transferView, mainMenuController);
			view.addContentToList(transferView);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class NewTransferButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			WithdrawableAccount payer = (WithdrawableAccount) DialogView.getOptionFromList(
					user.getWithdrawableAccounts(), "Séléctionez un compte éméteur", "Nouveau virement");
			if (payer == null) {
				return;
			}
			NewTransferView newTransferView = new NewTransferView();
			NewTransferController controller = new NewTransferController(user, newTransferView, payer);
			String[] options = new String[]{"Confirmer", "Annuler"};
			controller.setupView();
			controller.displayView();
			int confirmation = JOptionPane.showOptionDialog(null, newTransferView, "Nouveau virement",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
			if (confirmation == JOptionPane.OK_OPTION) {
				try {
					String password = DialogView.askPassword();
					if (password != null && password.equals(user.getPassword())) {
						controller.createNewTransfer();
					}
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
	
	class PayeeManagmentButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AllPayeesView allPayees = new AllPayeesView();
			AllPayeesController controller = new AllPayeesController(user, allPayees, mainMenuController);
			mainMenuController.changeView(allPayees);
			controller.setupView();
			controller.displayView();
		}
	}
	
}
