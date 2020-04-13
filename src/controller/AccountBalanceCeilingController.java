package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import aux.CustomException;
import model.PELAccount;
import model.PersonalAccount;
import model.WithdrawableAccount;
import view.DialogView;
import view.ProgressBarButtonView;

public class AccountBalanceCeilingController extends Controller {
	
	PersonalAccount account;
	private ProgressBarButtonView view;
	
	public AccountBalanceCeilingController(PersonalAccount account, ProgressBarButtonView view) {
		this.account = account;
		this.view = view;
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtonsActions() {
		view.addButtonListener(new ButtonActionListener());
		view.addAuxButtonListener(new AuxButtonActionListener());
	}

	@Override
	public void setupViewText() {
		
		int min = (int) account.getMinBalance();
		int max = (int) account.getMaxBalance();
		double current = account.getBalance();
		int displayedCurrent = (int) current;
		
		view.setProgressBarMin(min);
		view.setProgressBarMax(max);
		view.setProgressBarCurrent(displayedCurrent);
		
		Font font = new Font(Font.SERIF, Font.ITALIC, 12);
		
		for (int i = 0; i < 4; i++) {
			view.setLabelFont(i, font);
		}
		
		for (int i = 0; i < 2; i++) {
			view.setAuxLabelFont(i, font);
		}
		
		view.setLabelText(0, "Solde actuel: ");
		view.setLabelText(1, Double.toString(current));
		view.setLabelText(2, "Maximum: ");
		view.setLabelText(3, Integer.toString(max));
		
		view.setAuxLabelText(0, "Minimum: ");
		view.setAuxLabelText(1, Integer.toString(min));
		
		view.setButtonText("Modifier");
		view.setAuxButtonText("Modifier");
		
		if (!(account instanceof PELAccount)) {
			view.addAuxComponents();
		}
		
		view.setBorder(BorderFactory.createTitledBorder("Plafond de liquidité"));
	}
	
	
	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringInput("Entrez nouveau seuil max: ", 
					"Confirmez seuil max: ", "Édition seuil max", false, false);
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) throws CustomException {
							int newMax = Integer.parseInt(newData);
							account.setMaxBalance(newMax);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runDoubleInputEditionProtocol(input[0], input[1], "[0-9]*", account.getOwner().getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
	
	class AuxButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringInput("Entrez nouveau seuil min: ", 
					"Confirmez seuil min: ", "Édition seuil min", false, false);
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) throws CustomException {
							int newMin = Integer.parseInt(newData);
							((WithdrawableAccount)account).setMinBalance(newMin);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runDoubleInputEditionProtocol(input[0], input[1], "[0-9]*", account.getOwner().getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
}
