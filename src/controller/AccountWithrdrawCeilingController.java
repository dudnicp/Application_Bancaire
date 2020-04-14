package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import aux.CustomException;
import model.WithdrawableAccount;
import view.DialogView;
import view.ProgressBarButtonView;

public class AccountWithrdrawCeilingController extends Controller {

	private WithdrawableAccount account;
	private ProgressBarButtonView view;
	
	public AccountWithrdrawCeilingController(WithdrawableAccount account, ProgressBarButtonView view) {
		this.account = account;
		this.view = view;
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}
	

	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(0, new ButtonActionListener());
	}

	@Override
	public void setupViewText() {
		
		int min = 0;
		int max = (int) account.getMaxWithdraw();
		double current = account.getCurrentlyEngagedAmount();
		int displayedCurrent = (int) current;
		
		view.setProgressBarMin(min);
		view.setProgressBarMax(max);
		view.setProgressBarCurrent(displayedCurrent);
		
		Font font = new Font(Font.SERIF, Font.ITALIC, 12);
		for (int i = 0; i < 4; i++) {
			view.setLabelFont(i, font);
		}
		
		view.setLabelText(0, "Montant engagé: ");
		view.setLabelText(1, Double.toString(current));
		view.setLabelText(2, "Maximum: ");
		view.setLabelText(3, Integer.toString(max));
		
		view.setButtonText(0, "Modifier");
		view.setBorder(BorderFactory.createTitledBorder("Plafond de payement/retrait"));
	}
	
	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = DialogView.getStringInput("Augmentation souhaitée", "Édition capacité de payement");
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) throws CustomException {
							int amount = Integer.parseInt(newData);
							account.addToMaxWithdraw(amount);
							DialogView.displayInfoDialog("Nouvelle capacité de payement enregistrée avec succès.", null);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runSimpleInputEditionProtocol(input, "[0-9]*", account.getOwner().getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}

}
