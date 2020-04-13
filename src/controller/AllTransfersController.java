package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import model.PermanentTransfer;
import model.User;
import view.AllPayeesView;
import view.AllTransfersView;
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
			NewTransferView newTransferView = new NewTransferView();
			NewTransferController controller = new NewTransferController(user, newTransferView);
			String[] options = new String[]{"Confirmer", "Annuler"};
			controller.setupView();
			controller.displayView();
			JOptionPane.showOptionDialog(null, newTransferView, "Nouveau virement",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
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
