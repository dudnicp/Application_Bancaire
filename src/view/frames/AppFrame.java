package view.frames;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.Controller;
import view.panels.AccountsPanel;
import view.panels.DocumentsPanel;
import view.panels.LoansPanel;
import view.panels.PreferencesPanel;
import view.panels.TransfersPanel;

public class AppFrame extends JFrame {
	private static final long serialVersionUID = -912989417505291367L;
	private JTabbedPane tabs;
	
	private Controller controller;
	
	public AppFrame(Controller controller) {
		
		this.controller = controller;
		
		this.setTitle("Bank-App");
		this.setSize(new Dimension(1000, 600));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabs = new JTabbedPane(JTabbedPane.LEFT);
		
		tabs.add("Accounts", new AccountsPanel());
		tabs.add("Transfers", new TransfersPanel());
		tabs.add("Loans", new LoansPanel());
		tabs.add("Documents", new DocumentsPanel());
		tabs.add("Preferences", new PreferencesPanel());
		
		this.getContentPane().add(tabs);
		this.setVisible(true);
	}
}
