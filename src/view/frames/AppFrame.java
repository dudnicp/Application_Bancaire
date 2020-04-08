package view.frames;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabs = new JTabbedPane(JTabbedPane.LEFT);
		
		tabs.add(new AccountsPanel());
		JLabel tab0 = new JLabel("Accounts");
		tab0.setPreferredSize(new Dimension(100, 100));
		tabs.setTabComponentAt(0, tab0);
		
		tabs.add(new TransfersPanel());
		JLabel tab1 = new JLabel("Transfers");
		tab1.setPreferredSize(new Dimension(100, 100));
		tabs.setTabComponentAt(1, tab1);
		
		tabs.add(new LoansPanel());
		JLabel tab2 = new JLabel("Loans");
		tab2.setPreferredSize(new Dimension(100, 100));
		tabs.setTabComponentAt(2, tab2);
		
		tabs.add(new DocumentsPanel());
		JLabel tab3 = new JLabel("Documents");
		tab3.setPreferredSize(new Dimension(100, 100));
		tabs.setTabComponentAt(3, tab3);
		
		tabs.add(new PreferencesPanel());
		JLabel tab4 = new JLabel("Preferences");
		tab4.setPreferredSize(new Dimension(100, 100));
		tabs.setTabComponentAt(4, tab4);
		

		this.getContentPane().add(tabs);
		this.setVisible(true);
	}
}
