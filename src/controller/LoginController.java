package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import aux.InvalidPasswordException;
import aux.InvalidUserException;
import model.BankData;
import model.User;
import view.LoginView;
import view.MainMenuView;

public class LoginController extends Controller {
	BankData bank;
	LoginView view;
	
	public LoginController(BankData bank, LoginView view) {
		this.bank = bank;
		this.view = view;
	}
	
	public void login(String id, String password) {
		try {
			User loggedUser = bank.login(id, password);
			view.displayWelcomeMessage(loggedUser.personalData());
			view.dispose();
			createMainView(loggedUser);
		} catch (InvalidUserException e) {
			view.displayInvalidUserError();
		} catch (InvalidPasswordException e) {
			view.displayInvalidPasswordError();
		}
	}
	
	
	private void createMainView(User user) {
		MainMenuView mainMenu = new MainMenuView();
		MainMenuController controller = new MainMenuController(user, bank, mainMenu);
		controller.setupView();
	}
	
	@Override
	public void setupViewText() {
		// View initialised by default
	}
	
	class LoginButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			login(view.getEnteredId(), view.getEnteredPassword());
		}
	}
	
	class LoginKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				login(view.getEnteredId(), view.getEnteredPassword());
				break;
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// pass, nothing to do here
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// pass, nothing to do here
		}
	}

	@Override
	public void setupViewButtonsActions() {
		view.addLoginListener(new LoginButtonListener(), new LoginKeyListener());
	}
}
