package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import model.CurrentAccount;
import model.PersonalAccount;
import model.WithdrawableAccount;
import view.AccountInfoView;
import view.AllAccountsView;
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
				new AccountBalanceCeilingController(account.getOwner(), account, progressBar);
		controller.setupView();
		controller.displayView();
		view.addContent(progressBar);
		
		if (account instanceof WithdrawableAccount) {
			ProgressBarButtonView progressBarBis = new ProgressBarButtonView();
			AccountWithrdrawCeilingController controllerBis = 
					new AccountWithrdrawCeilingController(account.getOwner(), (WithdrawableAccount)account, progressBarBis);
			controllerBis.setupView();
			controllerBis.displayView();
			view.addContent(progressBarBis);
		}
		
		JButton button = new JButton("Retour à la liste des comptes");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AllAccountsView accountsList = new AllAccountsView();
				AllAccountsController controller = new AllAccountsController(
						mainMenuController.getLoggedUser(), accountsList, mainMenuController);
				mainMenuController.changeView(accountsList);
				controller.setupView();
				controller.displayView();
			}
		});
		view.addContent(button);
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtons() {
		// TODO
	}

}
