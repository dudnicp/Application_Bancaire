package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import aux.CustomException;
import model.Account;
import model.OneTimeTransferTransaction;
import model.PermanentTransfer;
import model.TransferRegularity;
import model.User;
import model.WithdrawableAccount;
import view.ContentResumeListView;
import view.DialogView;
import view.NewTransferView;
import view.PermanentTransferView;

public class AllTransfersController extends Controller {

	private User user;
	private ContentResumeListView view;
	private MainMenuController mainMenuController;
	
	public AllTransfersController(User user, ContentResumeListView view, MainMenuController controller) {
		this.user = user;
		this.view = view;
		this.mainMenuController = controller;
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
		view.setContentListBorder(0, title1);
		
		for (PermanentTransfer transfer : user.getPermanentTransfers()) {
			PermanentTransferView transferView = new PermanentTransferView();
			PermanentTransferController controller = new PermanentTransferController(transfer, transferView, mainMenuController);
			view.addContentToList(0, transferView);
			controller.setupView();
		}
	}
	
	public void createNewTransfer(NewTransferView newView, WithdrawableAccount payer) throws CustomException, ParseException {
		Account payee = (Account) newView.getSelectedOption();
		double amount;
		if (newView.getTextField().matches("[0-9]+[.][0-9]*") || newView.getTextField().matches("[0-9]*[.][0-9]+")) {
			amount = Double.parseDouble(newView.getTextField());
		} else if (newView.getTextField().matches("[0-9]+")) {
			amount = Integer.parseInt(newView.getTextField());
		} else {
			throw new CustomException("Montant invalide");
		}
		if (newView.isCheckBoxChecked()) {
			
			String day = newView.getAuxField(0);
			String month = newView.getAuxField(1);
			String year = newView.getAuxField(2);
			
			DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
			Date date = dateFormat.parse(day + " " + month + " " + year);
				
			if (date.after(new Date())) {
				TransferRegularity regularity = (TransferRegularity) newView.getAuxOption();
				PermanentTransfer transfer = new PermanentTransfer(payer, payee, amount, date, regularity);
				user.addPermanentTransfer(transfer);
				DialogView.displayInfoDialog("Virement permanent programmé avec succès.", null);
				
				PermanentTransferView permanentTransferView = new PermanentTransferView();
				PermanentTransferController controller = new PermanentTransferController(
						transfer, permanentTransferView, mainMenuController);
				view.addContentToList(0, permanentTransferView);
				controller.setupView();
				
			} else {
				throw new CustomException("Impossible d'enregistrer le virement: la date de premier versement dépassée.");
			}
		} else {
			payer.pay(amount, payee, new OneTimeTransferTransaction());
			DialogView.displayInfoDialog("Virement effecué avec succès.", null);
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
			int confirmation = JOptionPane.showOptionDialog(null, newTransferView, "Nouveau virement",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
			if (confirmation == JOptionPane.OK_OPTION) {
				try {
					String password = DialogView.askPassword();
					if (password != null && password.equals(user.getPassword())) {
						createNewTransfer(newTransferView, payer);
					}
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				} catch (ParseException e2) {
					DialogView.displayError("Date au mauvais format");
				}
			}
		}
	}
	
	class PayeeManagmentButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ContentResumeListView allPayees = new ContentResumeListView(1, 2);
			AllPayeesController controller = new AllPayeesController(user, allPayees, mainMenuController);
			mainMenuController.changeView(allPayees);
			controller.setupView();
		}
	}
	
}
