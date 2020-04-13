package controller;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import model.PermanentTransfer;
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
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtonsActions() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setupViewText() {
		view.setButtonText(0, "Éditer montant");
		view.setButtonText(1, "Éditer régulariter");
		view.setButtonText(2, "Supprimer ce virement");
		view.setButtonText(3, "Retour à la liste des virements");
		
		Font titleFont = new Font("Arial", Font.BOLD, 15);
		TitledBorder border = new TitledBorder("Comptes courrants");
		border.setTitleFont(titleFont);
		view.setContentBorder(border);
	}

}
