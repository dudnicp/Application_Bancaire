package view.frames;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.UserController;
import model.events.Event;
import model.events.LoginEvent;
import model.paterns.Observer;
import view.panels.AccountsPanel;
import view.panels.LoansPanel;
import view.panels.PreferencesPanel;
import view.panels.TransfersPanel;


public class AppFrame extends JFrame implements Observer {
	private static final long serialVersionUID = -912989417505291367L;
	
	private UserController controller;
	
	private static final String ACCOUNTS = "accounts";
	private static final String TRANSFERS = "transfers";
	private static final String LOANS = "loans";
	private static final String PREFERENCES = "preferences";
	
	private CardLayout cardLayout;
	private JPanel tabs;
	
	private JPanel accountsPanel;
	private JPanel transfersPanel;
	private JPanel loansPanel;
	private JPanel preferencesPanel;
	
	
	public AppFrame(UserController controller) {
		
		this.controller = controller;
		
		this.setTitle("Bank-App");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.cardLayout = new CardLayout();
		JPanel contentPane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Dimension buttonDimension = new Dimension(150,80);
		Dimension panelDimension = new Dimension(450,390);
		
		JButton accountsButton = new JButton("Comptes");
		accountsButton.setPreferredSize(buttonDimension);
		accountsButton.addActionListener(new AccountsButtonListener());
		
		JButton transferButton = new JButton("Virements");
		transferButton.setPreferredSize(buttonDimension);
		transferButton.addActionListener(new TransfersButtonListener());
		
		JButton loansButton = new JButton("Emprunts");
		loansButton.setPreferredSize(buttonDimension);
		loansButton.addActionListener(new LoansButtonListener());
		
		JButton preferencesButton = new JButton("Réglages");
		preferencesButton.setPreferredSize(new Dimension(150, 50));
		preferencesButton.addActionListener(new PreferencesButtonListener());
		
		JButton decoButton = new JButton("Deconnéxion");
		decoButton.setPreferredSize(new Dimension(150, 50));
		decoButton.addActionListener(new DecoButtonListener());
		
		JButton quitButton = new JButton("Quitter");
		quitButton.setPreferredSize(new Dimension(150, 50));
		quitButton.addActionListener(new QuitButtonListener());
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		contentPane.add(accountsButton, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		contentPane.add(transferButton, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		contentPane.add(loansButton, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		contentPane.add(preferencesButton, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		contentPane.add(decoButton, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		contentPane.add(quitButton, c);
		
		
		tabs = new JPanel(cardLayout);
		accountsPanel = new JPanel();
		accountsPanel.setPreferredSize(panelDimension);
		tabs.add(accountsPanel, ACCOUNTS);
		
		transfersPanel = new JPanel();
		transfersPanel.setPreferredSize(panelDimension);
		tabs.add(transfersPanel, TRANSFERS);
		
		loansPanel = new JPanel();
		loansPanel.setPreferredSize(panelDimension);
		tabs.add(loansPanel, LOANS);
		
		preferencesPanel = new JPanel();
		preferencesPanel.setPreferredSize(panelDimension);
		tabs.add(preferencesPanel, PREFERENCES);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		contentPane.add(tabs, c);
		
		setupAccountsPanel();
		cardLayout.show(tabs, ACCOUNTS);
		
		this.setContentPane(contentPane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void setupAccountsPanel() {
		accountsPanel.removeAll();
		accountsPanel.add(new AccountsPanel(controller));
//		accountsPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
	public void setupTransfersPanel() {
		transfersPanel.removeAll();
		transfersPanel.add(new TransfersPanel());
//		transfersPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
	public void setupLoansPanel() {
		loansPanel.removeAll();
		loansPanel.add(new LoansPanel());
//		accountsPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
	public void setupPreferencesPanel() {
		preferencesPanel.removeAll();
		preferencesPanel.add(new PreferencesPanel());
//		accountsPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
	class AccountsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setupAccountsPanel();
			cardLayout.show(tabs, ACCOUNTS);
		}
	}
	
	class TransfersButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setupTransfersPanel();
			cardLayout.show(tabs, TRANSFERS);
		}
	}
	
	class LoansButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setupLoansPanel();
			cardLayout.show(tabs, LOANS);
		}
	}
	
	class PreferencesButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setupPreferencesPanel();
			cardLayout.show(tabs, PREFERENCES);
		}
	}
	
	class DecoButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.disconnectCurrentUser();
			LoginFrame newLogin = new LoginFrame(controller);
			controller.getLoginData().addObserver(newLogin);
		}
	}
	
	class QuitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.disconnectCurrentUser();
		}
	}

	@Override
	public void update(Event e) {
		LoginEvent loginEvent = (LoginEvent) e;
		switch (loginEvent.getLoginStatus()) {
		case LoginEvent.DISCONNECTED:
			controller.getLoginData().removeObservers();
			dispose();
			JOptionPane.showMessageDialog(null, "Vous avez été déconnecté.", "À bientôt!",
											JOptionPane.INFORMATION_MESSAGE);
			
			break;
		default:
			break;
		}
	}
}
