package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.CurrentAccount;
import model.PELAccount;
import model.PersonalAccount;
import model.WithdrawableAccount;
import view.AccountHistoryView;
import view.AccountInfoView;
import view.AllAccountsView;
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
		Font infoFont = new Font(Font.DIALOG, Font.BOLD, 13);
		
		for (int i = 0; i < 5; i++) {
			view.setInfoLabelFont(i, infoFont);
		}
		
		view.setInfoLabelText(0, "Nom du compte: " + account.getName());
		view.setInfoLabelText(1, "Titulaire: "  + account.getOwner().personalData());
		view.setInfoLabelText(2, "Type : " + account.getType().toString());
		view.setInfoLabelText(3, "IBAN: " + account.getIban()); 
		
		Date date = account.getOpeningDate();
		int day = date.getDate();
		int month = date.getMonth() + 1;
		int year = date.getYear() + 1900;
		view.setInfoLabelText(4, "Date d'ouverture: " + day + "/" + month + "/" + year);
		view.setInfoPanelBorder(BorderFactory.createTitledBorder("Infos compte"));
		
		ProgressBarButtonView progressBar = new ProgressBarButtonView();
		AccountBalanceCeilingController controller = 
				new AccountBalanceCeilingController(account, progressBar);
		controller.setupView();
		controller.displayView();
		view.addContent(progressBar);
		
		if (account instanceof WithdrawableAccount) {
			ProgressBarButtonView progressBarBis = new ProgressBarButtonView();
			AccountWithrdrawCeilingController controllerBis = 
					new AccountWithrdrawCeilingController((WithdrawableAccount)account, progressBarBis);
			controllerBis.setupView();
			controllerBis.displayView();
			view.addContent(progressBarBis);
		}
		
		
		if (account instanceof PELAccount) {
			
			JButton closePelButton = new JButton("Clôturer PEL");
			closePelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int confirmation = DialogView.getIntOption("Êtes vous sûrs de vouloir clôturer ce compte?", "Confirmation");
					if (confirmation == JOptionPane.OK_OPTION) {
						CurrentAccount dest = (CurrentAccount) DialogView.getOptionFromList(
								account.getOwner().getCurrentAccounts(), 
								"Séléctionnez un compte sur lequel verser l'argent: ", 
								"Clôturation du PEL");
						if (dest != null) {
							String password = DialogView.askPassword();
							if (password != null) {
								if (password.equals(account.getOwner().getPassword())) {
									((PELAccount) account).close(dest);
									DialogView.displayModificationSuccessMessage();
									
									AllAccountsView newView = new AllAccountsView();
									AllAccountsController controller = new AllAccountsController(
											mainMenuController.getLoggedUser(), newView, mainMenuController);
									mainMenuController.changeView(newView);
									controller.setupView();
									controller.displayView();
								}
							}
						}
					}
				}
			});
			view.addContent(closePelButton);
			
			JButton returnButton = new JButton("Retour à la liste des comptes");
			returnButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			view.addContent(returnButton);
		} else {
			JButton returnButton = new JButton("Retour à l'historiques des transactions");
			returnButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AccountHistoryView accountView = new AccountHistoryView();
					AccountHistoryController controller = new AccountHistoryController(account, accountView, mainMenuController);
					mainMenuController.changeView(accountView);
					controller.setupView();
					controller.displayView();
				}
			});
			view.addContent(returnButton);
		}
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtonsActions() {
		// TODO
	}

}
