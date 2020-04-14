package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import aux.CustomException;
import model.CurrentAccount;
import model.PELAccount;
import model.PersonalAccount;
import model.WithdrawableAccount;
import view.AccountHistoryView;
import view.AccountInfoView;
import view.ContentResumeListView;
import view.DialogView;
import view.ProgressBarButtonView;

public class AccountInfoController extends Controller {
	
	private PersonalAccount account;
	private AccountInfoView view;
	private MainMenuController mainMenuController;
	
	public AccountInfoController(PersonalAccount account, AccountInfoView view, MainMenuController controller) {
		this.account = account;
		this.view = view;
		this.mainMenuController = controller;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setupViewText() {
		Font infoFont = new Font(Font.DIALOG, Font.BOLD, 14);
		
		for (int i = 0; i < 5; i++) {
			view.setLabelFont(i, infoFont);
		}
		
		view.setLabelText(0, "Nom du compte: " + account.getName());
		view.setLabelText(1, "Titulaire: "  + account.getOwner().personalData());
		view.setLabelText(2, "Type : " + account.getType().toString());
		view.setLabelText(3, "IBAN: " + account.getIban()); 
		
		Date date = account.getOpeningDate();
		int day = date.getDate();
		int month = date.getMonth() + 1;
		int year = date.getYear() + 1900;
		view.setLabelText(4, "Date d'ouverture: " + day + "/" + month + "/" + year);
		view.setInfoPanelBorder(BorderFactory.createTitledBorder("Infos compte"));
		
		if (account instanceof WithdrawableAccount) {
			ProgressBarButtonView progressBarBis = new ProgressBarButtonView();
			AccountWithrdrawCeilingController controllerBis = 
					new AccountWithrdrawCeilingController((WithdrawableAccount)account, progressBarBis);
			controllerBis.setupView();
			view.addContent(progressBarBis);
		}
		
		
		if (account instanceof PELAccount) {
			
			JButton closePelButton = new JButton("Clôturer PEL");
			closePelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int confirmation = DialogView.askConfirmation("Êtes vous sûrs de vouloir clôturer ce compte?", "Confirmation");
					if (confirmation == JOptionPane.OK_OPTION) {
						CurrentAccount dest = (CurrentAccount) DialogView.getOptionFromList(
								account.getOwner().getCurrentAccounts(), 
								"Séléctionnez un compte sur lequel verser l'argent: ", 
								"Clôturation du PEL");
						if (dest != null) {
							String password = DialogView.askPassword();
							if (password != null) {
								if (password.equals(account.getOwner().getPassword())) {
									try {
										((PELAccount) account).close(dest);
										DialogView.displayInfoDialog("PEL clôturé avec succès.", null);
										
										ContentResumeListView newView = new ContentResumeListView(3,0);
										AllAccountsController controller = new AllAccountsController(
												mainMenuController.getLoggedUser(), newView, mainMenuController);
										mainMenuController.changeView(newView);
										controller.setupView();
									} catch (CustomException e2) {
										DialogView.displayError(e2.getString());
									}
								}
							}
						}
					}
				}
			});
			view.addContent(closePelButton);
		}
		
		JButton returnButton = new JButton("Retour à l'historiques des transactions");
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountHistoryView accountView = new AccountHistoryView();
				AccountHistoryController controller = new AccountHistoryController(account, accountView, mainMenuController);
				mainMenuController.changeView(accountView);
				controller.setupView();
			}
		});
		view.addContent(returnButton);	
	}

	@Override
	public void setupViewButtonsActions() {
		// TODO
	}

}
