package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import aux.CustomException;
import model.PermanentTransfer;
import model.TransferRegularity;
import view.SummaryListView;
import view.DialogView;
import view.PermanentTransferModificationView;

public class PermanentTransferModificationController extends Controller {
	
	private PermanentTransfer transfer;
	private PermanentTransferModificationView view;
	private MainMenuController mainMenuController;
	
	public PermanentTransferModificationController(PermanentTransfer transfer, 
			PermanentTransferModificationView view, MainMenuController controller) {
		this.transfer = transfer;
		this.view = view;
		this.mainMenuController = controller;
	}

	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(0, new AmountEditingButtonListener());
		view.addButtonAction(1, new RegularityEditingButtonListener());
		view.addButtonAction(2, new AnnulTransferButtonListener());
		view.addButtonAction(3, new RetrunButtonListener());
	}

	@Override
	public void setupViewText() {
		view.setButtonText(0, "Éditer montant");
		view.setButtonText(1, "Éditer régularité");
		view.setButtonText(2, "Supprimer ce virement");
		view.setButtonText(3, "Retour à la liste des virements");
		
		Font titleFont = new Font("Arial", Font.BOLD, 15);
		TitledBorder border = new TitledBorder("Modifications possibles");
		border.setTitleFont(titleFont);
		view.setContentBorder(border);
	}
	
	
	class RetrunButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SummaryListView transfersView = new SummaryListView(1,2);
			AllTransfersController controller = new AllTransfersController(
					mainMenuController.getLoggedUser(), transfersView, mainMenuController);
			mainMenuController.changeView(transfersView);
			controller.setupView();
		}
	}
	
	class AmountEditingButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringInput(
					"Entrez nouveau montant: ", "Confirmez montant: ", "Édition Montant", false, false);
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) {
							double newAmount = Double.parseDouble(newData);
							transfer.setAmount(newAmount);
							DialogView.displayInfoDialog("Nouveau montant enregistré avec succès.", null);
						}
						@Override
						public void update() {
							// nothing to be done here
						}
					}
					Editor editor = new Editor();
					editor.runDoubleInputEditionProtocol(
							input[0], input[1], "[0-9]*", mainMenuController.getLoggedUser().getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
	
	class RegularityEditingButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<TransferRegularity> options = new ArrayList<TransferRegularity>();
			for (TransferRegularity transferRegularity : TransferRegularity.values()) {
				options.add(transferRegularity);
			}
			TransferRegularity input = (TransferRegularity) DialogView.getOptionFromList(
					options, "Choisissez une régularité", "Édition régularité");
			if (input != null) {
				String password = DialogView.askPassword();
				if (password != null && password.equals(mainMenuController.getLoggedUser().getPassword())) {
					transfer.setRegularity(input);
					DialogView.displayInfoDialog("Nouvelle régularité enregirstrée avec succès.", null);
				}
			}
		}
	}
	
	class AnnulTransferButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int confirmation = DialogView.askConfirmation("Êtes vous sûrs de vouloir supprimer ce virement?", "Confirmation");
			if (confirmation == JOptionPane.OK_OPTION) {
				String password = DialogView.askPassword();
				if (password != null && mainMenuController.getLoggedUser().getPassword().equals(password)) {
					mainMenuController.getLoggedUser().removePermanentTransfer(transfer);
					DialogView.displayInfoDialog("Le virement a bien été supprimé", "Confirmation");
					SummaryListView transfersView = new SummaryListView(1,2);
					AllTransfersController controller = new AllTransfersController(
							mainMenuController.getLoggedUser(), transfersView, mainMenuController);
					mainMenuController.changeView(transfersView);
					controller.setupView();
				}
			}
		}
	}

}
