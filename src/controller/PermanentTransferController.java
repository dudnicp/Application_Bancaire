package controller;

import java.awt.Font;
import java.util.Date;

import model.PermanentTransfer;
import view.Interaction;
import view.PermanentTransferModificationView;
import view.PermanentTransferView;

public class PermanentTransferController extends Controller {

	private PermanentTransfer transfer;
	private PermanentTransferView view;
	private MainMenuController mainMenuController;
	
	public PermanentTransferController(PermanentTransfer transfer, PermanentTransferView view, MainMenuController controller) {
		this.transfer = transfer;
		this.view = view;
		this.mainMenuController = controller;
	}
	
	
	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtonsActions() {
		// No buttons on this view
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setupViewText() {
		
		Font auxFont = new Font(Font.SERIF, Font.ITALIC, 12);
		Font infoFont = new Font(Font.DIALOG, Font.BOLD, 12);
		
		view.setLabelText(0, "Depuis le compte:");
		view.setLabelFont(0, auxFont);
		view.setLabelText(1, transfer.getPayer().toString());
		view.setLabelFont(1, infoFont);
		view.setLabelText(2, "Vers le compte:");
		view.setLabelFont(2, auxFont);
		view.setLabelText(3, transfer.getPayee().toString());
		view.setLabelFont(3, infoFont);
		view.setLabelText(4, "Montant: ");
		view.setLabelFont(4, auxFont);
		view.setLabelText(5,  transfer.getAmount() + " € - " + transfer.getRegularity());
		view.setLabelFont(5, infoFont);
		Date transactionDate = transfer.getFirstTransactionDate();
		int day = transactionDate.getDate();
		int month = transactionDate.getMonth() + 1;
		int year = transactionDate.getYear() + 1900;
		view.setLabelText(6, "Date de premier versement: ");
		view.setLabelFont(6, auxFont);
		view.setLabelText(7, day + "/" + month + "/" + year);
		view.setLabelFont(7, infoFont);
		
		view.addInteraction(new OpenPermanentTransferModificationView());
	}
	
	class OpenPermanentTransferModificationView implements Interaction {
		@Override
		public void perform() {
			PermanentTransferModificationView newView = new PermanentTransferModificationView();
			PermanentTransferModificationController controller = 
					new PermanentTransferModificationController(transfer, newView, mainMenuController);
			mainMenuController.changeView(newView);
			controller.setupView();
			controller.displayView();
		}
	}
}
